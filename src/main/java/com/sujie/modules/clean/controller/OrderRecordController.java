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

import com.sujie.modules.clean.entity.OrderRecordEntity;
import com.sujie.modules.clean.service.OrderRecordService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 订单保洁信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/orderrecord")
public class OrderRecordController {
    @Autowired
    private OrderRecordService orderRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:orderrecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:orderrecord:info")
    public R info(@PathVariable("id") Integer id){
		OrderRecordEntity orderRecord = orderRecordService.getById(id);

        return R.ok().put("orderRecord", orderRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:orderrecord:save")
    public R save(@RequestBody OrderRecordEntity orderRecord){
		orderRecordService.save(orderRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:orderrecord:update")
    public R update(@RequestBody OrderRecordEntity orderRecord){
		orderRecordService.updateById(orderRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:orderrecord:delete")
    public R delete(@RequestBody Integer[] ids){
		orderRecordService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
