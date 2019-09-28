package com.sujie.modules.clean.controller;

import java.math.BigDecimal;
import java.util.*;

import com.sujie.common.utils.MD5Utils;
import com.sujie.modules.clean.entity.HomestayChargeRecordEntity;
import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.service.HomestayChargeRecordService;
import org.apache.commons.lang.StringUtils;
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
    @Autowired
    private HomestayChargeRecordService homestayChargeRecordService;

    /**
     * 列表
     */
    @GetMapping("/homestayInfos")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = homestayInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/listHomestayInfo")
    public R listAll() {
        List<HomestayInfoEntity> list = homestayInfoService.list();
        return R.ok().put("list", list);
    }

    /**
     * 信息
     */
    @GetMapping("/homestayInfo/{id}")
    public R info(@PathVariable("id") Integer id) {
        HomestayInfoEntity homestayInfo = homestayInfoService.getById(id);

        return R.ok().put("homestayInfo", homestayInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/homestayInfo")
    public R save(@RequestBody HomestayInfoEntity homestayInfo) {
        try {
            homestayInfo.setHomestayId(UUID.randomUUID().toString().replace("-", ""));
            homestayInfo.setPassword(MD5Utils.getMD5(homestayInfo.getPassword()));
            homestayInfoService.save(homestayInfo);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("保存失败！");
        }

    }

    @RequestMapping("/getAllWorkPlace")
    public R getAllWorkPlace() {
        List<String> allWorkPalce = homestayInfoService.getAllWorkPalce();
        return R.ok().put("places", allWorkPalce);
    }

    /**
     * 充值金额
     *
     * @param homestayInfo
     * @return
     */
    @RequestMapping("/recharge")
    public R recharge(@RequestBody HomestayInfoEntity homestayInfo) {
        return homestayInfoService.recharge(homestayInfo);
    }


    /**
     * 修改
     */
    @PostMapping("/updateHomeStayInfo")
    public R update(@RequestBody HomestayInfoEntity homestayInfo) {

        return homestayInfoService.updateHomestayInfo(homestayInfo);
    }

    @DeleteMapping("/homestayInfo/{id}")
    public R delete(@PathVariable("id") Integer id) {
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
