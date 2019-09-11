package com.sujie.modules.clean.controller;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.common.utils.*;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 保洁阿姨信息
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/staffinfo")
public class StaffInfoController {
    @Autowired
    private StaffInfoService staffInfoService;

//    @RequestMapping("/login")
//    public R login(@RequestParam("cleanerPhone") String cleanerPhone, @RequestParam("pwd") String pwd) {
//        QueryWrapper<StaffInfoEntity> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("telphone", cleanerPhone);
//        if (StringUtils.isBlank(cleanerPhone)) {
//            return R.error(0, "手机号不能为空");
//        }
//        if (StringUtils.isBlank(pwd)) {
//            return R.error(0, "密码不能为空");
//        }
//        // 查询详细
//
//        StaffInfoEntity staffInfoEntity = staffInfoService.getOne(queryWrapper);
//
//        if (staffInfoEntity == null) {
//            return R.error(0, "手机号不存在");
//        } else {
//            String pwdMD5 = MD5Utils.getMD5(pwd);
//            String password = staffInfoEntity.getPassword();
//            if (pwdMD5.equalsIgnoreCase(password)) {
//                return R.appOK();
//            } else {
//                return R.error(0, "密码错误");
//            }
//        }
//    }

    /**
     * 查询所有阿姨信息
     * @return
     */
    @RequestMapping("/listAllStaff")
    public R listAllStaff(){
        List<Map<String, Object>> maps = staffInfoService.listMaps();
        return R.ok().put("list",maps);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        PageUtils page = staffInfoService.queryPage(params);

        return R.ok().put("page", page);
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

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        StaffInfoEntity staffInfo = staffInfoService.getById(id);

        return R.ok().put("staffInfo", staffInfo);
    }

    @RequestMapping("/getStaffPhoto")
    public void getStaffPhoto(@RequestParam String id, HttpServletResponse response) {


        if (StringUtils.isNotBlank(id)) {
            StaffInfoEntity staffInfo = staffInfoService.getById(id);
            String photoPath = staffInfo.getPhoto();
            response.setContentType("image/jpeg");
            FileInputStream is = ImageUtils.getFileInputStream(photoPath);

            if (is != null) {
                int i = 0; // 得到文件大小
                try {
                    i = is.available();
                    byte data[] = new byte[i];
                    is.read(data); //
                    is.close();
                    response.setContentType("image/jpeg");  // 设置返回的文件类型
                    OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
                    toClient.write(data); // 输出数据
                    toClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody StaffInfoEntity staffInfo) {

        try {
            staffInfo.setStaffId(UUIDUtils.getUUIDHex());
            staffInfo.setPassword(MD5Utils.getMD5(staffInfo.getPassword()));
            staffInfoService.save(staffInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("保存失败！");
        }

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StaffInfoEntity staffInfo) {
        StaffInfoEntity oldstaffInfo = staffInfoService.getById(staffInfo.getId());
        if(!oldstaffInfo.getPassword().equalsIgnoreCase(staffInfo.getPassword())){
            staffInfo.setPassword(MD5Utils.getMD5(staffInfo.getPassword()));
        }
        staffInfoService.updateById(staffInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        staffInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
