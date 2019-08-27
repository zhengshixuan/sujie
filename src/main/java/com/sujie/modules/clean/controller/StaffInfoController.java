package com.sujie.modules.clean.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import com.sujie.common.utils.UUIDUtils;
import com.sujie.common.utils.UploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


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
    public R list(@RequestParam Map<String, Object> params){

        PageUtils page = staffInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public R upload(@RequestParam MultipartFile file){
        R r = UploadUtils.upload(file);
        return r;
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		StaffInfoEntity staffInfo = staffInfoService.getById(id);

        return R.ok().put("staffInfo", staffInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody StaffInfoEntity staffInfo){

        staffInfo.setStaffId(UUIDUtils.getUUIDHex());
		staffInfoService.save(staffInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StaffInfoEntity staffInfo){
		staffInfoService.updateById(staffInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		staffInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
