package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sujie.modules.clean.entity.OrderEntity;
import com.sujie.modules.clean.vo.OrderVO;
import com.sujie.modules.clean.vo.RoomInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 保洁订单主表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

    /**
     * 根据订单状态查询订单信息
     * @param params
     * @return
     */
    List<Map<String,Object>> listPreOrderByStatus(Map<String,Object> params);

    /**
     * 查询订单状态为待保洁和保洁中的数据
     * @param params
     * @return
     */
    List<Map<String,Object>> listOrderByStatus(Map<String,Object> params);




    List<Map<String,Object>> getOrdersByHomestayIdAndRoomId(Map<String, Object> params);
    /**
     * 更新订单状态
     * @param params
     * @return
     */
    int updateCleanStatusCode(Map<String,Object> params);


    Integer getPreOrderCount(Map<String,Object> params);
    /**
     * 查询房间详细信息
     */
    Map<String,Object> findRoomInfoDetail(Map<String,Object> params);
    /**
     * 查询今日保洁单
     * @param params
     * @return
     */
    List<Map<String,Object>> listTodayOrder(Map<String, Object> params);

    List<Map<String,Object>> listRoomCleanRecordApp(Map<String, Object> params);
    /**
     * @param page
     * @param params
     * @return
     */
    IPage<OrderVO> listOrderVO(IPage<OrderVO> page, @Param("params") Map<String,Object> params);

    /**
     * 查询预排单总数
     * @param params
     * @return
     */
    Integer getPreparOrderCount(Map<String,Object> params);

    /**
     * 查询预排单详细
     * @param params
     * @return
     */
    List<Map<String,Object>> listPreOrder(Map<String,Object> params);

    /**
     * 查询预排单详细
     * @param params
     * @return
     */
    List<Map<String,Object>> listPreOrderDetail(Map<String,Object> params);


    /**
     * 查询订单信息
     * @param map
     *
     * @return
     */
    List<Map<String, Object>> searchOrders(Map<String, Object> map);


    /**
     * 通过民宿id和保洁状态查询消费总额
     * @param params
     * @return
     */
    BigDecimal getConCount(Map<String,Object> params);

}
