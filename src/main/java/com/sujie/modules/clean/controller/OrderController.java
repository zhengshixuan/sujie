package com.sujie.modules.clean.controller;

import java.math.BigDecimal;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sujie.modules.clean.entity.OrderRecordEntity;
import com.sujie.modules.clean.service.OrderRecordService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sujie.modules.clean.entity.OrderEntity;
import com.sujie.modules.clean.service.OrderService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
import org.thymeleaf.expression.Maps;


/**
 * 保洁订单主表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRecordService orderRecordService;

    /**
     * 派送订单给阿姨
     *
     * @param params
     * @return
     */
    @RequestMapping("sendOrder")
    public R sendOrder(@RequestBody Map<String, Object> params) {
        String id = (String) params.get("id");
        String staffId = (String) params.get("staffId");
        String staffCost = (String) params.get("staffCost");
        String bossCost = (String) params.get("bossCost");
        OrderEntity orderEntity = orderService.getById(id);

        if (orderEntity != null) {
            orderEntity.setCleanStatusCode(1);
            QueryWrapper<OrderRecordEntity> orderRecordEntityQueryWrapper = new QueryWrapper<>();
            OrderRecordEntity orderRecordEntity = orderRecordService.getOrderRecordByOrderId(orderEntity.getOrderId());
            if (null != orderRecordEntity) {
                orderRecordEntity.setStaffId(staffId);
                BigDecimal staffCostDouble = new BigDecimal(staffCost);
                BigDecimal bossCostDobule = new BigDecimal(bossCost);
                orderRecordEntity.setStatus(1);
                orderRecordEntity.setStaffCost(staffCostDouble);
                orderRecordEntity.setBossCost(bossCostDobule);
                orderService.saveOrUpdate(orderEntity);
                orderRecordService.saveOrUpdate(orderRecordEntity);
                return R.ok();
            } else {
                return R.error("派单失败,请核实此订单是否已经派单");
            }
        } else {
            return R.error("派单失败,请联系系统管理员");
        }
    }

    @RequestMapping("cancelOrder")
    public R cancelOrder(@RequestBody Map<String, Object> params) {
        String id = (String) params.get("id");
        //String staffId = (String) params.get("staffId");
//        OrderEntity orderEntity = orderService.getById(id);
        OrderRecordEntity orderRecordEntity = orderRecordService.getById(id);
        orderRecordEntity.setStatus(0);
        orderRecordEntity.setStaffId("0");
        orderRecordService.saveOrUpdate(orderRecordEntity);
        return R.ok();
    }

    /**
     * 获取各地区各机构待保洁总数
     *
     * @param map
     * @return
     */

    @GetMapping("/listPreOrder")
    public R listPreOrder(@RequestParam Map<String, Object> map) {
        //状态为预保洁,且开始保洁时间为明天的总数
        Integer total = orderService.getPreorderCount(map);
        //状态为预保洁,且开始时间为明天,按地区划分
        List<Map<String, Object>> list = orderService.listPreOrder(map);
        if (list != null) {
            for (Map<String, Object> preOrderMap : list) {
                //查询预保洁状态订单详细信息
                List<Map<String, Object>> maps = orderService.listPreOrderDetail(preOrderMap);
                preOrderMap.put("detail", maps);
            }
        }
        return R.ok().put("preparOrders", list).put("total", total);
    }


    /**
     * 获取详细预排单
     *
     * @param map
     * @return
     */
    @RequestMapping("/listPreOrderDetail")
    public R listPreOrderDetail(@RequestParam Map<String, Object> map) {
        List<Map<String, Object>> maps = orderService.listPreOrderDetail(map);
        return R.ok().put("preparOrdersDetail", maps);
    }


    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 查询已完成的记录
     *
     * @return
     */
    @RequestMapping("/listRoomCleanRecord")
    public R listRoomCleanRecord(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.listRoomCleanRecord(params);
        return R.ok().put("page", page);
    }

    /**
     * 查询待保洁的订单
     *
     * @return
     */
    @RequestMapping("/listPrepareCleanOrder")
    public R listPrepareCleanOrder(@RequestParam Map<String, Object> params) {
        PageUtils page = orderService.listPrepareCleanOrder(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clean:order:info")
    public R info(@PathVariable("id") Integer id) {
        OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clean:order:save")
    public R save(@RequestBody OrderEntity order) {
        orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clean:order:update")
    public R update(@RequestBody OrderEntity order) {
        orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clean:order:delete")
    public R delete(@RequestBody Integer[] ids) {
        orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }


}
