package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

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

    List<Map<String,Object>> listPreOrder(Map<String,Object> params);

    List<Map<String,Object>> listPreOrderDetail(Map<String,Object> params);


}
