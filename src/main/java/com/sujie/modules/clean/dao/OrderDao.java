package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sujie.modules.clean.entity.OrderEntity;
import com.sujie.modules.clean.vo.OrderVO;
import com.sujie.modules.clean.vo.RoomInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    IPage<OrderVO> listOrderVO(IPage<OrderVO> page, @Param("params") Map<String,Object> params);

    Integer getPreparOrderCount(Map<String,Object> params);

    List<Map<String,Object>> listPreOrder(Map<String,Object> params);

    /**
     * 查询已经保洁完成的订单
     * @param params
     * @return
     */
    List<Map<String,Object>> listPreOrderDetail(Map<String,Object> params);


}
