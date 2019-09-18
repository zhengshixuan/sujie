package com.sujie.modules.clean.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.common.config.Trans;
import com.sujie.common.utils.MD5Utils;
import com.sujie.common.utils.R;
import com.sujie.common.utils.UUIDUtils;
import com.sujie.modules.clean.entity.*;
import com.sujie.modules.clean.service.*;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 1.登录
     *
     * @param params
     * @return
     */
    @RequestMapping("/login")
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
     * 二．门店信息
     *
     * @param params
     * @return
     */
    @RequestMapping("/getHomestayInfo")
    public R getHomestayInfo(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "手机号不能为空");
        }
        // 查询详细
        Map<String, Object> homestayInfoEntity = this.homestayInfoService.getHomestayInfoDetail(params);
        return R.appOK().put("data", homestayInfoEntity);
    }

    /**
     * 三．派单页面  用户点击“派单”按钮，显示所有房间
     *
     * @param params
     * @return
     */
    @RequestMapping("/getRoomInfos")
    public R getRoomInfos(@RequestBody Map<String, Object> params) {
        String operatorPhone = (String) params.get("operatorPhone");
        if (StringUtils.isBlank(operatorPhone)) {
            return R.error(0, "手机号不能为空");
        }
        List<Map<String, Object>> roomInfos = roomInfoService.getRoomInfos(params);
        return R.appOK().put("data", roomInfos);
    }

    @RequestMapping("/getRoomInfoDetail")
    public R getRoomInfoDetail(@RequestBody Map<String, Object> params) {
        String homeStayBreand = (String) params.get("homeStayBreand");
        String address = (String) params.get("address");
        String roomNo = (String) params.get("roomNo");
        if (StringUtils.isBlank(homeStayBreand)) {
            return R.error("民宿品牌不能为空");
        } else {
            if (StringUtils.isBlank(address)) {
                return R.error("民宿地址不能为空");
            } else {
                if (StringUtils.isBlank(roomNo)) {
                    return R.error("房间号不能为空");
                } else {
                    Map<String, Object> roomInfoDetail = roomInfoService.getRoomInfoDetail(params);
                    return R.appOK().put("data", roomInfoDetail);
                }
            }
        }

    }

    @RequestMapping("/sendPreOrder")
    public R sendPreOrder(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        String homeStayBreand = (String) params.get("homeStayBreand");
        String address = (String) params.get("address");
        String roomNo = (String) params.get("roomNo");
        String clearStart = (String) params.get("clearStart");
        String clearEnd = (String) params.get("clearEnd");
        String clearType = (String) params.get("clearType");
        String ischeckOut = (String) params.get("ischeckOut");
        String state = (String) params.get("state");

        if (StringUtils.isNotBlank(homestayId)) {
            if (StringUtils.isNotBlank(homeStayBreand)) {
                if (StringUtils.isNotBlank(address)) {
                    if (StringUtils.isNotBlank(roomNo)) {
                        if (StringUtils.isNotBlank(clearStart)) {
                            if (StringUtils.isNotBlank(clearEnd)) {
                                if (StringUtils.isNotBlank(clearType)) {
                                    if (StringUtils.isNotBlank(ischeckOut)) {
                                        //房间信息
                                        QueryWrapper<RoomInfoEntity> roomInfoEntityQueryWrapper = new QueryWrapper<RoomInfoEntity>();
                                        roomInfoEntityQueryWrapper.eq("homestay_id", homestayId);
                                        roomInfoEntityQueryWrapper.eq("room_id", roomNo);
                                        RoomInfoEntity roomInfo = roomInfoService.getOne(roomInfoEntityQueryWrapper);

                                        //订单表
                                        OrderEntity orderEntity = new OrderEntity();

                                        //订单详细表
                                        OrderRecordEntity orderRecordEntity = new OrderRecordEntity();

                                        try {
                                            orderEntity.setOrderId(UUIDUtils.getUUIDHex());
                                            orderEntity.setHomestayId(homestayId);
                                            orderEntity.setRoomId(roomNo);
                                            orderEntity.setCleanStatusCode(0);
                                            orderEntity.setCleanType(Trans.trans(Integer.valueOf(clearType)));
                                            orderEntity.setIsCheckOut(Trans.trans(Integer.valueOf(ischeckOut)));
                                            Date startDate = SDF.parse(clearStart);
                                            Date endDate = SDF.parse(clearEnd);
                                            orderEntity.setPreStartCleanDate(startDate);
                                            orderEntity.setPreEndCleanDate(endDate);
                                            orderEntity.setCreateDate(new Date());

                                            orderRecordEntity.setOrderId(orderEntity.getOrderId());
                                            orderRecordEntity.setIsFirst(1);
                                            orderRecordEntity.setIsExtraBed(roomInfo.getIsExtraBed());
                                            orderRecordEntity.setStatus(0);
                                            this.orderRecordService.saveOrUpdate(orderRecordEntity);
                                            this.orderService.saveOrUpdate(orderEntity);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                            return R.error("请输入正确的日期格式yyyy-MM-dd hh:mm");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            return R.error("保存失败");
                                        }

                                    } else {
                                        return R.error("是否退房不能为空");
                                    }
                                } else {
                                    return R.error("保洁类型不能为空");
                                }
                            } else {
                                return R.error("保洁结束时间不能为空");
                            }
                        } else {
                            return R.error("保洁开始时间不能为空");
                        }
                    } else {
                        return R.error("房间号不能为空");
                    }
                } else {
                    return R.error("民宿地址不能为空");
                }
            } else {
                return R.error("民宿名称不能为空");
            }
        } else {
            return R.error("民宿id不能为空");
        }


        return R.appOK();
    }

    @RequestMapping("/sendOrder")
    public R sendOrder(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        String roomNo = (String) params.get("roomNo");
        String homeStayBreand = (String) params.get("homeStayBreand");
        String address = (String) params.get("address");


        String clearStart = (String) params.get("clearStart");
        String clearEnd = (String) params.get("clearEnd");
        String clearType = (String) params.get("clearType");
        String ischeckOut = (String) params.get("ischeckOut");
        String state = (String) params.get("state");

        return R.appOK();
    }

    @RequestMapping("/getPreOrders")
    public R getPreOrders(@RequestBody Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error("民宿id不能为空");
        } else {
            //0为预打扫
            params.put("cleanStatusCode", 0);
            List<Map<String, Object>> mapList = orderService.listPreOrderByStatus(params);
            return R.appOK().put("data", mapList);
        }
    }

    @RequestMapping("/canclePreOrder")
    public R canclePreOrder(@RequestBody Map<String, Object> params) {
        String orderId = (String) params.get("orderId");
        if (StringUtils.isBlank(orderId)) {
            R.error("订单id不能为空");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("order_id", orderId);
            orderService.removeByMap(map);
            orderRecordService.removeByMap(map);
        }
        return R.appOK();
    }
    @RequestMapping("/getOrders")
    public R getOrders(@RequestBody Map<String, Object> params){
        String homestayId = (String) params.get("homestayId");
        if (StringUtils.isBlank(homestayId)) {
            return R.error("民宿id不能为空");
        } else {
            //1为
            params.put("cleanStatusCode", 1);
            List<Map<String, Object>> mapList = orderService.listOrderByStatus(params);
            return R.appOK().put("data", mapList);
        }
    }

}
