package com.sujie.modules.clean.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.common.utils.MD5Utils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.entity.HomestayInfoEntity;
import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.HomestayInfoService;
import com.sujie.modules.clean.service.RoomInfoService;
import com.sujie.modules.clean.service.StaffInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boss")
public class Boss {
    @Autowired
    private HomestayInfoService homestayInfoService;
    @Autowired
    private RoomInfoService roomInfoService;

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
                                        if (StringUtils.isNotBlank(state)) {

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            return R.error("民宿id不能为空");
        }


        return R.appOK();
    }


    public R getPreOrders(@RequestBody Map<String, Object> params) {

        return R.appOK();
    }

}
