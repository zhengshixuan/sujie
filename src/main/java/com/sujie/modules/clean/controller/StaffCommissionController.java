package com.sujie.modules.clean.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sujie.modules.clean.entity.StaffCommissionEntity;
import com.sujie.modules.clean.service.StaffCommissionService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 保洁阿姨的提成
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/staffcommission")
public class StaffCommissionController {
    @Autowired
    private StaffCommissionService staffCommissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:staffcommission:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = staffCommissionService.queryPage(params);

        return R.ok().put("page", page);
    }




    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:staffcommission:info")
    public R info(@PathVariable("id") Integer id){
		StaffCommissionEntity staffCommission = staffCommissionService.getById(id);

        return R.ok().put("staffCommission", staffCommission);
    }
    @RequestMapping("/getStaffCommission")
    public R getStaffCommission(@RequestBody Map<String,Object> params){
        StaffCommissionEntity staffCommission = staffCommissionService.getStaffCommissionByStaffIdAndRoomType(params);
        return R.ok().put("staffCommission",staffCommission);

    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StaffCommissionEntity staffCommission){
        try {
            QueryWrapper<StaffCommissionEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("staff_id", staffCommission.getStaffId()).eq("room_type", staffCommission.getRoomType());
            StaffCommissionEntity staffCommissionEntity = staffCommissionService.getOne(queryWrapper);
            if(null!=staffCommission){
                staffCommission.setId(staffCommissionEntity.getId());
            }
            boolean b = staffCommissionService.saveOrUpdate(staffCommission);
            if(b){
                return R.ok();
            }else{
                R.error("保存失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return   R.error("保存失败！");
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:staffcommission:update")
    public R update(@RequestBody StaffCommissionEntity staffCommission){
		staffCommissionService.updateById(staffCommission);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:staffcommission:delete")
    public R delete(@RequestBody Integer[] ids){
		staffCommissionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
