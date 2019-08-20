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

import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.service.RoomInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 房间信息
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
@RestController
@RequestMapping("/roominfo")
public class RoomInfoController {
    @Autowired
    private RoomInfoService roomInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		RoomInfoEntity roomInfo = roomInfoService.getById(id);

        return R.ok().put("roomInfo", roomInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RoomInfoEntity roomInfo){
		roomInfoService.save(roomInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RoomInfoEntity roomInfo){
		roomInfoService.updateById(roomInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		roomInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
