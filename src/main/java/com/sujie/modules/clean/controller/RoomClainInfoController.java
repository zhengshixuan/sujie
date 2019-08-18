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

import com.sujie.modules.clean.entity.RoomClainInfoEntity;
import com.sujie.modules.clean.service.RoomClainInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 房间内特殊信息显示
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
@RestController
@RequestMapping("/roomclaininfo")
public class RoomClainInfoController {
    @Autowired
    private RoomClainInfoService roomClainInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("clean:roomclaininfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roomClainInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:roomclaininfo:info")
    public R info(@PathVariable("id") Integer id){
		RoomClainInfoEntity roomClainInfo = roomClainInfoService.getById(id);

        return R.ok().put("roomClainInfo", roomClainInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:roomclaininfo:save")
    public R save(@RequestBody RoomClainInfoEntity roomClainInfo){
		roomClainInfoService.save(roomClainInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:roomclaininfo:update")
    public R update(@RequestBody RoomClainInfoEntity roomClainInfo){
		roomClainInfoService.updateById(roomClainInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:roomclaininfo:delete")
    public R delete(@RequestBody Integer[] ids){
		roomClainInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
