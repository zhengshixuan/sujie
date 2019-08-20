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

import com.sujie.modules.clean.entity.StaffWorkPlaceEntity;
import com.sujie.modules.clean.service.StaffWorkPlaceService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 保洁阿姨工作位置
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/staffworkplace")
public class StaffWorkPlaceController {
    @Autowired
    private StaffWorkPlaceService staffWorkPlaceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:staffworkplace:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = staffWorkPlaceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:staffworkplace:info")
    public R info(@PathVariable("id") String id){
		StaffWorkPlaceEntity staffWorkPlace = staffWorkPlaceService.getById(id);

        return R.ok().put("staffWorkPlace", staffWorkPlace);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StaffWorkPlaceEntity staffWorkPlace){

        staffWorkPlaceService.save(staffWorkPlace);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:staffworkplace:update")
    public R update(@RequestBody StaffWorkPlaceEntity staffWorkPlace){
		staffWorkPlaceService.updateById(staffWorkPlace);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:staffworkplace:delete")
    public R delete(@RequestBody String[] ids){
		staffWorkPlaceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
