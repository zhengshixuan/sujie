package com.sujie.modules.clean.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.common.config.Trans;
import com.sujie.common.utils.MD5Utils;
import com.sujie.common.utils.R;
import com.sujie.common.utils.UUIDUtils;
import com.sujie.modules.clean.entity.*;
import com.sujie.modules.clean.service.*;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("老板端")
@RestController
@RequestMapping("/boss")
public class Boss {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    @Autowired
    private HomestayInfoService homestayInfoService;
    @Autowired
    private RoomInfoService roomInfoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRecordService orderRecordService;
    @Autowired
    private AdImageService adImageService;
    @Autowired
    private HomestayChargeRecordService homestayChargeRecordService;

    /**
     * 1.登录
     *
     * @param params
     * @return
     */
    @ApiOperation(value = "登录", notes = "根据手机号密码用户登录")
    @PostMapping("/login")
    public R login(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        String pwd = (String) params.get("pwd");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "手机号不能为空");
        }
        if (StringUtils.isBlank(pwd)) {
            return R.error(0, "密码不能为空");
        }
        QueryWrapper<HomestayInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("operators_telephone", operatorPhone);

        // 查询详细
        HomestayInfoEntity homestayInfoEntity = this.homestayInfoService.getOne(queryWrapper);

        if (homestayInfoEntity == null) {
            return R.error(0, "运营者手机号不存在");
        } else {
            String pwdMD5 = MD5Utils.getMD5(pwd);
            String password = homestayInfoEntity.getPassword();
            if (pwdMD5.equalsIgnoreCase(password)) {
                return R.appOK();
            } else {
                return R.error(0, "密码错误");
            }
        }
    }

    /**
     * 修改密码
     *
     * @param params 入参
     * @return R
     */
    @PostMapping("/updatePassword")
    public R updatePassword(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        String initPwd = (String) params.get("initPwd");
        String modPwd = (String) params.get("modPwd");

        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "运营人员手机号码不能为空");
        } else {

            if (StringUtils.isBlank(initPwd)) {
                return R.error(0, "初始密码不能为空");
            } else {
                if (StringUtils.isBlank(modPwd)) {
                    return R.error(0, "修改密码不能为空");
                } else {

                    QueryWrapper<HomestayInfoEntity> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("operators_telephone", operatorPhone);
                    // 查询详细

                    HomestayInfoEntity homestayInfoEntity = homestayInfoService.getOne(queryWrapper);
                    if (homestayInfoEntity == null) {
                        return R.error(0, "未查到相关运营人员手机号");
                    } else {
                        if (!MD5Utils.getMD5(initPwd).equalsIgnoreCase(homestayInfoEntity.getPassword())) {
                            return R.error(0, "初始密码不正确");
                        } else {
                            homestayInfoEntity.setPassword(MD5Utils.getMD5(modPwd));
                            boolean b = homestayInfoService.saveOrUpdate(homestayInfoEntity);
                            if (b) {
                                return R.appOK();
                            } else {
                                return R.error(0, "修改失败,请联系系统管理员");
                            }
                        }
                    }
                }

            }
        }
    }

    /**
     * 查询展示图片信息
     *
     * @return
     */
    @PostMapping("/listPic")
    public R listPic() {
        List<Map<String, Object>> maps = adImageService.listPic();
        return R.appOK().put("data", maps);
    }

    /**
     * 查询余额信息
     *
     * @param params
     * @return
     */
    @PostMapping("/getConDetail")
    public R getConDetail(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error(0, "民宿id不能为空");
        } else {
            QueryWrapper<HomestayInfoEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("homestay_id", params.get("homestayId"));
            HomestayInfoEntity homestayInfoEntity = homestayInfoService.getOne(queryWrapper);
            if (null == homestayInfoEntity) {
                return R.error(0, "请输入正确的民宿id");
            } else {
                Map<String, Object> map = new HashMap<>();
                BigDecimal recharge = homestayChargeRecordService.getChargeCount(params);
                BigDecimal consum = orderService.getConCount(params);
                if (null == homestayInfoEntity.getBalance()) {
                    map.put("remain", 0);
                } else {
                    map.put("remain", homestayInfoEntity.getBalance());
                }
                map.put("isMember", Trans.trans(homestayInfoEntity.getIsVip()));
                map.put("recharge", recharge);
                map.put("consum", consum);
                return R.appOK().put("data", map);
            }
        }

    }

    /**
     * 查询民宿客服等相关信息
     *
     * @param params
     * @return
     */
    @PostMapping("/getConsumer")
    public R getOtherHomestayInfo(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error(0, "民宿id不能为空");
        } else {
            QueryWrapper<HomestayInfoEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("homestay_id", params.get("homestayId"));
            HomestayInfoEntity homestayInfoEntity = homestayInfoService.getOne(queryWrapper);
            if (null == homestayInfoEntity) {
                return R.error(0, "请输入正确的民宿id");
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("telephone", homestayInfoEntity.getWorkPhone());
                map.put("clientWX", homestayInfoEntity.getCustomerWx());
                map.put("clientPhone", homestayInfoEntity.getCustomerPhone());
                map.put("workTime", homestayInfoEntity.getWorkTime());
                return R.appOK().put("data", map);
            }
        }

    }


    /**
     * 二．门店信息
     *
     * @param params
     * @return
     */
    @PostMapping("/getHomestayInfo")
    public R getHomestayInfo(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "运营者手机号不能为空");
        } else {
            // 查询详细
            Map<String, Object> homestayInfoEntity = this.homestayInfoService.getHomestayInfoDetail(params);
            if (null == homestayInfoEntity) {
                return R.error(0, "未找到此运营者手机号相关民宿信息");
            }
            return R.appOK().put("data", homestayInfoEntity);
        }
    }

    /**
     * 三．派单页面  用户点击“派单”按钮，显示所有房间
     *
     * @param params
     * @return
     */
    @PostMapping("/getRoomInfos")
    public R getRoomInfos(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "手机号不能为空");
        } else {
            List<Map<String, Object>> roomInfos = roomInfoService.getRoomInfos(params);
            return R.appOK().put("data", roomInfos);
        }
    }

    /**
     * 显示整个房间的详细信息
     *
     * @param params
     * @return
     */
    @PostMapping("/getRoomInfoDetail")
    public R getRoomInfoDetail(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        String roomNo = (String) params.get("roomNo");
        if (StringUtils.isBlank(homestayId)) {
            return R.error(0, "民宿id不能为空");
        } else {
            if (StringUtils.isBlank(roomNo)) {
                return R.error(0, "房间号不能为空");
            } else {
                Map<String, Object> roomInfoDetail = roomInfoService.getRoomInfoDetail(params);
                return R.appOK().put("data", roomInfoDetail);
            }
        }

    }

    /**
     * 添加预打扫订单,状态为0
     *
     * @param params
     * @return
     */
    @PostMapping("/sendPreOrder")
    public R sendPreOrder(@RequestBody Map<String, Object> params) {
        return orderService.savePreOrder(params);
    }

    /**
     * 添加订单,状态修改为1
     *
     * @param params
     * @return
     */
    @PostMapping("/sendOrder")
    public R sendOrder(@RequestBody Map<String, Object> params) {
        return orderService.saveOrder(params);
    }

    /**
     * 查询待保洁订单
     *
     * @param params
     * @return
     */
    @PostMapping("/getPreOrders")
    public R getPreOrders(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error(0, "民宿id不能为空");
        } else {
            //0为预打扫
            params.put("cleanStatusCode", 0);
            List<Map<String, Object>> mapList = orderService.listPreOrderByStatus(params);
            return R.appOK().put("data", mapList);
        }
    }

    @PostMapping("/cancleOrder")
    public R canclePreOrder(@RequestBody Map<String, Object> params) {
        String orderId = (String) params.get("orderId");
        if (StringUtils.isBlank(orderId)) {
            return R.error(0, "订单id不能为空");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("order_id", orderId);
            OrderEntity orderEntity = orderService.getOrderByOrderId(orderId);
            if (null == orderEntity) {
                return R.error(0, "未找到相应的订单,请上传正确的订单号");
            } else {
                try {
                    orderService.removeByMap(map);
                    orderRecordService.removeByMap(map);
                } catch (Exception e) {
                    e.printStackTrace();
                    return R.error(0, "取消订单失败");
                }
            }
        }
        return R.appOK();
    }

    /**
     * 查询未完成的数据
     *
     * @param params
     * @return
     */
    @PostMapping("/getOrders")
    public R getOrders(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error(0, "民宿id不能为空");
        } else {
            //1为待保洁
            params.put("cleanStatusCode1", 1);
            //2位保洁中
            params.put("cleanStatusCode2", 2);
            List<Map<String, Object>> mapList = orderService.listOrderByStatus(params);
            return R.appOK().put("data", mapList);
        }
    }

    /**
     * 查询已完成的数据
     *
     * @param params 入参
     * @return
     */
    @PostMapping("/getCompleteOrders")
    public R getCompleteOrders(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error("民宿id不能为空");
        } else {
            //3为保洁完成
            params.put("cleanStatusCode", 3);
            List<Map<String, Object>> mapList = orderService.listOrderByStatus(params);
            return R.appOK().put("data", mapList);
        }
    }

    /**
     * 查询已完成订单详细信息
     *
     * @param params
     * @return
     */
    @PostMapping("/getCompleteOrderDetail")
    public R getCompleteOrderRoomInfo(@RequestBody Map<String, Object> params) {
        String orderId = (String) params.get("orderId");
        if (StringUtils.isBlank(orderId)) {
            return R.error(0, "订单号不能为空");
        } else {
            OrderEntity order = orderService.getOrderByOrderId(orderId);
            if (null != order) {
                params.put("homestayId", order.getHomestayId());
                params.put("roomNo", order.getRoomId());
                Map<String, Object> stringObjectHashMap = orderService.getComeleteOrder(params);
                return R.appOK().put("data", stringObjectHashMap);
            } else {
                return R.error(0, "未找到对应的订单号");
            }

        }

    }


    @PostMapping("/searchOrders")
    public R searchOrders(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error("运营者手机号不能为空");
        } else {
            String Date = (String) params.get("Date");
            String place = (String) params.get("place");
            String roomNo = (String) params.get("roomNo");
            List<Map<String, Object>> list = orderService.searchOrders(params);
            return R.appOK().put("data", list);
        }

    }

    @PostMapping("/listHomestayPlace")
    public R listHomestayPlace(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "运营者手机号不能为空");
        } else {
            List<String> allWorkPalce = homestayInfoService.getAllWorkPalce();
            return R.appOK().put("data", allWorkPalce);
        }
    }


}
