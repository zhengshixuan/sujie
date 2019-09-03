package com.sujie.modules.clean.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.common.utils.MD5Utils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author travel
 */
@RestController
@RequestMapping("/app")
public class App {


    @Autowired
    private StaffInfoService staffInfoService;

    @RequestMapping("/getTodayOrder")
    public R getTodayOrder(@RequestBody Map<String,Object> params){

        return null;
    }

    @RequestMapping("/login")
    public R login(@RequestParam("cleanerPhone") String cleanerPhone, @RequestParam("pwd") String pwd) {
        QueryWrapper<StaffInfoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("telphone", cleanerPhone);
        if (StringUtils.isBlank(cleanerPhone)) {
            return R.error(0, "手机号不能为空");
        }
        if (StringUtils.isBlank(pwd)) {
            return R.error(0, "密码不能为空");
        }
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

}
