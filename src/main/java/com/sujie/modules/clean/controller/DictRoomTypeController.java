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

import com.sujie.modules.clean.entity.DictRoomTypeEntity;
import com.sujie.modules.clean.service.DictRoomTypeService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 房间类型字典表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/dictroomtype")
public class DictRoomTypeController {
    @Autowired
    private DictRoomTypeService dictRoomTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        List<DictRoomTypeEntity> list = dictRoomTypeService.list();
//        PageUtils page = dictRoomTypeService.queryPage(params);

        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:dictroomtype:info")
    public R info(@PathVariable("id") String id){
		DictRoomTypeEntity dictRoomType = dictRoomTypeService.getById(id);

        return R.ok().put("dictRoomType", dictRoomType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:dictroomtype:save")
    public R save(@RequestBody DictRoomTypeEntity dictRoomType){
		dictRoomTypeService.save(dictRoomType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:dictroomtype:update")
    public R update(@RequestBody DictRoomTypeEntity dictRoomType){
		dictRoomTypeService.updateById(dictRoomType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:dictroomtype:delete")
    public R delete(@RequestBody String[] ids){
		dictRoomTypeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
