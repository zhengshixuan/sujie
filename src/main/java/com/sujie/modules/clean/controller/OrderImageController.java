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

import com.sujie.modules.clean.entity.OrderImageEntity;
import com.sujie.modules.clean.service.OrderImageService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 订单图片信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/orderimage")
public class OrderImageController {
    @Autowired
    private OrderImageService orderImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:orderimage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderImageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:orderimage:info")
    public R info(@PathVariable("id") Integer id){
		OrderImageEntity orderImage = orderImageService.getById(id);

        return R.ok().put("orderImage", orderImage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:orderimage:save")
    public R save(@RequestBody OrderImageEntity orderImage){
		orderImageService.save(orderImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:orderimage:update")
    public R update(@RequestBody OrderImageEntity orderImage){
		orderImageService.updateById(orderImage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:orderimage:delete")
    public R delete(@RequestBody Integer[] ids){
		orderImageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
