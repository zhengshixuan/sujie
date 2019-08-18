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

import com.sujie.modules.clean.entity.DictOrderStatusEntity;
import com.sujie.modules.clean.service.DictOrderStatusService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 订单状态字典表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/dictorderstatus")
public class DictOrderStatusController {
    @Autowired
    private DictOrderStatusService dictOrderStatusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:dictorderstatus:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dictOrderStatusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:dictorderstatus:info")
    public R info(@PathVariable("id") String id){
		DictOrderStatusEntity dictOrderStatus = dictOrderStatusService.getById(id);

        return R.ok().put("dictOrderStatus", dictOrderStatus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:dictorderstatus:save")
    public R save(@RequestBody DictOrderStatusEntity dictOrderStatus){
		dictOrderStatusService.save(dictOrderStatus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:dictorderstatus:update")
    public R update(@RequestBody DictOrderStatusEntity dictOrderStatus){
		dictOrderStatusService.updateById(dictOrderStatus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:dictorderstatus:delete")
    public R delete(@RequestBody String[] ids){
		dictOrderStatusService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
