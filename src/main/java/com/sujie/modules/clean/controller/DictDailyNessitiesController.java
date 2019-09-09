package com.sujie.modules.clean.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sujie.modules.clean.entity.DictDailyNessitiesEntity;
import com.sujie.modules.clean.service.DictDailyNessitiesService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 日用品字典表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/dictdailynessities")
public class DictDailyNessitiesController {
    @Autowired
    private DictDailyNessitiesService dictDailyNessitiesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:dictdailynessities:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictDailyNessitiesService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/listAll")
    public R listAll(){
        List<Map<String, Object>> list = dictDailyNessitiesService.listMaps();
        return R.ok().put("list",list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:dictdailynessities:info")
    public R info(@PathVariable("id") String id){
		DictDailyNessitiesEntity dictDailyNessities = dictDailyNessitiesService.getById(id);

        return R.ok().put("dictDailyNessities", dictDailyNessities);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:dictdailynessities:save")
    public R save(@RequestBody DictDailyNessitiesEntity dictDailyNessities){
		dictDailyNessitiesService.save(dictDailyNessities);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:dictdailynessities:update")
    public R update(@RequestBody DictDailyNessitiesEntity dictDailyNessities){
		dictDailyNessitiesService.updateById(dictDailyNessities);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:dictdailynessities:delete")
    public R delete(@RequestBody String[] ids){
		dictDailyNessitiesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
