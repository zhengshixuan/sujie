package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.entity.OrderEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 保洁订单主表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface OrderService extends IService<OrderEntity> {

    /**
     * 通过民宿id和房间id查询历史订单号
     * @param params
     * @return
     */
    List<Map<String,Object>> getOrdersByHomestayIdAndRoomId(Map<String,Object> params);
    /**
     * 更新订单信息
     * @param params
     * @return
     */
    boolean updateOrder(Map<String,Object> params);

    /**
     * 根据订单状态查询订单
     * @param params
     * @return
     */
    List<Map<String,Object>> listPreOrderByStatus(Map<String,Object> params);

    /**
     * 查询
     * @param params
     * @return
     */
    List<Map<String,Object>> listOrderByStatus(Map<String,Object> params);

    /**
     * 查询今日预排单
     * @param params
     * @return
     */
    Map<String,Object> getTodayPreOrder(Map<String,Object> params);


    /**
     * 查询订单详细和房间详细
     * @param params
     * @return
     */
    Map<String,Object> findOrderDetail(Map<String,Object> params);


    /**
     *
     * @param params
     * @return
     */
    List<Map<String,Object>> listTodayOrder(Map<String,Object> params);

    /**
     * 查询已经完成保洁的记录
     *
     * @param params
     * @return
     */
    PageUtils listRoomCleanRecord(Map<String, Object> params);

    /**
     * app端查询自己的保洁记录
     * @param params 入参
     * @return
     */
    List<Map<String,Object>> listRoomCleanRecordApp(Map<String, Object> params);

    /**
     * 查询待保洁的订单
     * @param params
     * @return
     */
    PageUtils listPrepareCleanOrder(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取预排单总数
     */
    List<Map<String, Object>> listPreOrder(Map<String, Object> map);

    /**
     * 查询待保洁的总数据
     *
     * @param map
     * @return
     */
    Integer getPreorderCount(Map<String, Object> map);

    /**
     * 获取详细预排单
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> listPreOrderDetail(Map<String, Object> map);


    /**
     * 老板端查找订单信息
     * @param map
     * @return
     */
    List<Map<String,Object>> searchOrders(Map<String, Object> map);

    /**
     * 根据民宿id,房间号,当前预保洁开始日期
     * @param map
     * @return OrderEntity
     */
    OrderEntity getOrder(Map<String, Object> map);

    /**
     * 通过订单id查询唯一订单
     * @param orderId
     * @return
     */
    OrderEntity getOrderByOrderId(String orderId);

    /**
     * 查询已经完成保洁的订单的详细
     * @param params
     * @return
     */
    Map<String,Object> getComeleteOrder(Map<String,Object> params);

    /**
     * 查询消费总金额,已订单完成为准
     * @param params
     * @return
     */
    BigDecimal getConCount(Map<String,Object> params);

    /**
     * 通过民宿id,房间号,当前日期,订单状态查询订单,每天同一个房间只允许一个订单号
     * @param params
     * @return
     */
    OrderEntity getOrderByHomestayIdANdRoomIdAndStatusCode(Map<String,Object> params);


    /**
     * 保存待保洁订单,状态为1
     * @param params
     * @return
     */
    R saveOrder(Map<String,Object> params);

    /**
     * 保存预保洁订单信息,状态为0
     * @param params
     * @return
     */
    R savePreOrder(Map<String,Object> params);



}

