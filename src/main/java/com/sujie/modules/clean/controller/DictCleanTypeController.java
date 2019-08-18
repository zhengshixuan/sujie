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

import com.sujie.modules.clean.entity.DictCleanTypeEntity;
import com.sujie.modules.clean.service.DictCleanTypeService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 保洁类型字典
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
@RestController
@RequestMapping("/dictcleantype")
public class DictCleanTypeController {
    @Autowired
    private DictCleanTypeService dictCleanTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:dictcleantype:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictCleanTypeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:dictcleantype:info")
    public R info(@PathVariable("id") String id){
		DictCleanTypeEntity dictCleanType = dictCleanTypeService.getById(id);

        return R.ok().put("dictCleanType", dictCleanType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:dictcleantype:save")
    public R save(@RequestBody DictCleanTypeEntity dictCleanType){
		dictCleanTypeService.save(dictCleanType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:dictcleantype:update")
    public R update(@RequestBody DictCleanTypeEntity dictCleanType){
		dictCleanTypeService.updateById(dictCleanType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:dictcleantype:delete")
    public R delete(@RequestBody String[] ids){
		dictCleanTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
