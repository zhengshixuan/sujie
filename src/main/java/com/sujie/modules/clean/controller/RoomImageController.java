package com.sujie.modules.clean.controller;

import java.util.Arrays;
import java.util.Map;

import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.entity.RoomImageEntity;
import com.sujie.modules.clean.service.RoomImageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




/**
 * 房间图片信息表
 *
 * @date 2019-09-01 13:55:56
 */
@RestController
@RequestMapping("generator/roomimage")
public class RoomImageController {
    @Autowired
    private RoomImageService roomImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomImageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		RoomImageEntity roomImage = roomImageService.getById(id);

        return R.ok().put("roomImage", roomImage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RoomImageEntity roomImage){
		roomImageService.save(roomImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RoomImageEntity roomImage){
		roomImageService.updateById(roomImage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		roomImageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
