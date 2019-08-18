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

import com.sujie.modules.clean.entity.RoomNessitiesReminderEntity;
import com.sujie.modules.clean.service.RoomNessitiesReminderService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 一次性物品不足提醒表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:14
 */
@RestController
@RequestMapping("/roomnessitiesreminder")
public class RoomNessitiesReminderController {
    @Autowired
    private RoomNessitiesReminderService roomNessitiesReminderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:roomnessitiesreminder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomNessitiesReminderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:roomnessitiesreminder:info")
    public R info(@PathVariable("id") String id){
		RoomNessitiesReminderEntity roomNessitiesReminder = roomNessitiesReminderService.getById(id);

        return R.ok().put("roomNessitiesReminder", roomNessitiesReminder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:roomnessitiesreminder:save")
    public R save(@RequestBody RoomNessitiesReminderEntity roomNessitiesReminder){
		roomNessitiesReminderService.save(roomNessitiesReminder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:roomnessitiesreminder:update")
    public R update(@RequestBody RoomNessitiesReminderEntity roomNessitiesReminder){
		roomNessitiesReminderService.updateById(roomNessitiesReminder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:roomnessitiesreminder:delete")
    public R delete(@RequestBody String[] ids){
		roomNessitiesReminderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
