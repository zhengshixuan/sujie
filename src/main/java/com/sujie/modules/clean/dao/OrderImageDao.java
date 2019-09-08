package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.OrderImageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单图片信息表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Mapper
public interface OrderImageDao extends BaseMapper<OrderImageEntity> {
    public List<Map<String, Object>> findOrderImageByOrderId(Map<String, Object> params);
	
}
