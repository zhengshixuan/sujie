package com.sujie.modules.clean.controller;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;

import com.sujie.common.utils.UUIDUtils;
import com.sujie.common.utils.ImageUtils;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
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
            String photoPath=staffInfo.getPhoto();
            response.setContentType("image/jpeg");
            FileInputStream is = ImageUtils.getFileInputStream(photoPath);

            if (is != null) {
                int i = 0; // 得到文件大小
                try {
                    i = is.available();
                    byte data[] = new byte[i];
                    is.read(data); // 读数据
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
