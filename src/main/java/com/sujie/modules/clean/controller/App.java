package com.sujie.modules.clean.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.common.utils.ImageUtils;
import com.sujie.common.utils.MD5Utils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.entity.RoomImageEntity;
import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.OrderService;
import com.sujie.modules.clean.service.RoomImageService;
import com.sujie.modules.clean.service.RoomInfoService;
import com.sujie.modules.clean.service.StaffInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author travel
 */
@RestController
@RequestMapping("/app")
public class App {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    private StaffInfoService staffInfoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomInfoService roomInfoService;
    @Autowired
    private RoomImageService roomImageService;

    /**
     * 1.登录
     * @param cleanerPhone
     * @param pwd
     * @return
     */
    @RequestMapping("/login")
    public R login(@RequestParam("cleanerPhone") String cleanerPhone, @RequestParam("pwd") String pwd) {
        if (StringUtils.isBlank(cleanerPhone)) {
            return R.error(0, "手机号不能为空");
        }
        if (StringUtils.isBlank(pwd)) {
            return R.error(0, "密码不能为空");
        }
        QueryWrapper<StaffInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("telphone", cleanerPhone);
        // 查询详细

        StaffInfoEntity staffInfoEntity = staffInfoService.getOne(queryWrapper);

        if (staffInfoEntity == null) {
            return R.error(0, "手机号不存在");
        } else {
            String pwdMD5 = MD5Utils.getMD5(pwd);
            String password = staffInfoEntity.getPassword();
            if (pwdMD5.equalsIgnoreCase(password)) {
                return R.appOK();
            } else {
                return R.error(0, "密码错误");
            }
        }
    }

    /**
     * 获取今日预排单
     * @param params
     * @return
     */
    @GetMapping()
    public R getTodayPreOrder(@RequestBody Map<String, Object> params) {
        String cleanerPhone = (String) params.get("cleanerPhone");
        if(StringUtils.isBlank(cleanerPhone)){
            return R.error(0,"保洁阿姨手机号码");
        }else{
            

        }

        return null;
    }


    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public R upload(@RequestParam MultipartFile file) {
        R r = ImageUtils.upload(file);
        return r;
    }

    @GetMapping("/getTodayOrder")
    public R getTodayOrder(@RequestBody Map<String, Object> params) {
        String cleanerPhone = (String) params.get("cleanerPhone");
        String address = (String) params.get("address");
        if (StringUtils.isBlank(cleanerPhone)) {
            return R.error(0, "保洁阿姨手机号码不能为空");
        }
        if (StringUtils.isBlank(address)) {
            return R.error(0, "保洁阿姨指定地址不能为空");

        }

        List<Map<String, Object>> list = orderService.listTodayOrder(params);


        return R.ok().put("list", list);
    }



    @RequestMapping("/updatePassword")
    public R updatePassword(@RequestBody Map<String, Object> params) {
        String cleanerPhone = (String) params.get("cleanerPhone");
        String initialPwd = (String) params.get("initialPwd");
        String modifyPwd = (String) params.get("modifyPwd");
        if (StringUtils.isBlank(cleanerPhone)) {
            return R.error(0, "保洁阿姨手机号码不能为空");
        } else {

            if (StringUtils.isBlank(initialPwd)) {
                return R.error(0, "初始密码不能为空");
            } else {
                if (StringUtils.isBlank(modifyPwd)) {
                    return R.error(0, "修改密码不能为空");
                } else {

                    QueryWrapper<StaffInfoEntity> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("telphone", cleanerPhone);
                    // 查询详细

                    StaffInfoEntity staffInfoEntity = staffInfoService.getOne(queryWrapper);
                    if (staffInfoEntity == null) {
                        return R.error(0, "保洁阿姨手机号码不存在");
                    } else {
                        if (!MD5Utils.getMD5(initialPwd).equalsIgnoreCase(staffInfoEntity.getPassword())) {
                            return R.error(0, "初始密码不正确");
                        } else {
                            staffInfoEntity.setPassword(MD5Utils.getMD5(modifyPwd));
                            boolean b = staffInfoService.saveOrUpdate(staffInfoEntity);
                            return R.appOK();
                        }
                    }
                }

            }
        }
    }
    @RequestMapping("/getRoomInfoDetail")
    public  R getRoomInfoDetail(@RequestBody Map<String,Object> params){
        String roomNo = (String) params.get("roomNo");
        String homeStayBreand = (String) params.get("homeStayBreand");
        String address = (String) params.get("address");
        if(StringUtils.isBlank(roomNo)){
            return R.error(0,"房间号不能为空");
        }
        if(StringUtils.isBlank(homeStayBreand)){
            return R.error(0,"民宿品牌不能为空");
        }
        if(StringUtils.isBlank(address)){
            return R.error(0,"民宿地址不能为空");
        }
        Map<String, Object> orderDetail = orderService.findOrderDetail(params);
        Map<String,Object> roomImageParamsMap = new HashMap<>();
        roomImageParamsMap.put("homestay_id",orderDetail.get("homestayId"));
        roomImageParamsMap.put("room_id",orderDetail.get("roomId"));
        List<RoomImageEntity> roomImageEntities = roomImageService.listByHomestayIdAndRoomId(roomImageParamsMap);
        orderDetail.put("image",roomImageEntities);
//        if(roomImageEntities!=null&&roomImageEntities.size()>0){
//            Map<String,Object> imageMap = new HashMap<>();
//            for (RoomImageEntity roomImageEntity : roomImageEntities) {
//
//            }
//        }
        return R.appOK().put("orderDetail",orderDetail);
    }

    @RequestMapping("/listRoomCleanRecordApp")
    public R listRoomCleanRecordApp(@RequestBody Map<String, Object> params) {
        String cleanerPhone = (String) params.get("cleanerPhone");
        String DateBegin = (String) params.get("DateBegin");
        String DateEnd = (String) params.get("DateEnd");
        if (StringUtils.isBlank(cleanerPhone)) {
            return R.error(0, "保洁阿姨手机号码不能为空");
        }
        if (StringUtils.isBlank(DateBegin)) {
            return R.error(0, "查询开始日期不能为空");
        }
        if (StringUtils.isBlank(DateEnd)) {
            return R.error(0, "查询结束日期不能为空");
        }
        List<Map<String, Object>> list = orderService.listRoomCleanRecordApp(params);
        return R.appOK().put("list", list);
    }


}
