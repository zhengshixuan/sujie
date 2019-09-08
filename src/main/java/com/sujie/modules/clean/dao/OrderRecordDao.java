package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.OrderRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 订单保洁信息表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Mapper
public interface OrderRecordDao extends BaseMapper<OrderRecordEntity> {

    int updateRecordStatus(Map<String,Object> params);
	
}
