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

import com.sujie.modules.clean.entity.DictCleanStatusEntity;
import com.sujie.modules.clean.service.DictCleanStatusService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 打扫状态字典
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/dictcleanstatus")
public class DictCleanStatusController {
    @Autowired
    private DictCleanStatusService dictCleanStatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:dictcleanstatus:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictCleanStatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:dictcleanstatus:info")
    public R info(@PathVariable("id") Integer id){
		DictCleanStatusEntity dictCleanStatus = dictCleanStatusService.getById(id);

        return R.ok().put("dictCleanStatus", dictCleanStatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:dictcleanstatus:save")
    public R save(@RequestBody DictCleanStatusEntity dictCleanStatus){
		dictCleanStatusService.save(dictCleanStatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:dictcleanstatus:update")
    public R update(@RequestBody DictCleanStatusEntity dictCleanStatus){
		dictCleanStatusService.updateById(dictCleanStatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:dictcleanstatus:delete")
    public R delete(@RequestBody Integer[] ids){
		dictCleanStatusService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
