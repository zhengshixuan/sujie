package com.sujie.modules.clean.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



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
    @RequiresPermissions("clean:staffinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = staffInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:staffinfo:info")
    public R info(@PathVariable("id") Integer id){
		StaffInfoEntity staffInfo = staffInfoService.getById(id);

        return R.ok().put("staffInfo", staffInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:staffinfo:save")
    public R save(@RequestBody StaffInfoEntity staffInfo){
		staffInfoService.save(staffInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:staffinfo:update")
    public R update(@RequestBody StaffInfoEntity staffInfo){
		staffInfoService.updateById(staffInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:staffinfo:delete")
    public R delete(@RequestBody Integer[] ids){
		staffInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
