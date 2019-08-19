package com.sujie.modules.clean.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sujie.modules.clean.entity.HomestayInfoEntity;
import com.sujie.modules.clean.service.HomestayInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;



/**
 * 民宿基本信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
@RestController
public class HomestayInfoController {
    @Autowired
    private HomestayInfoService homestayInfoService;

    /**
     * 列表
     */
    @GetMapping("/homestayInfos")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = homestayInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/homestayInfo/{id}")
    public R info(@PathVariable("id") Integer id){
		HomestayInfoEntity homestayInfo = homestayInfoService.getById(id);

        return R.ok().put("homestayInfo", homestayInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/homestayInfo")
    public R save(@RequestBody HomestayInfoEntity homestayInfo){

		homestayInfoService.save(homestayInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/homestayInfo")
    public R update(@RequestBody HomestayInfoEntity homestayInfo){
		homestayInfoService.updateById(homestayInfo);

        return R.ok();
    }

    @DeleteMapping("/homestayInfo/{id}")
    public R delete(@PathVariable("id") Integer id){
        homestayInfoService.removeById(id);
        return R.ok();
    }

//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Integer[] ids){
//		homestayInfoService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
