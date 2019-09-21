package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.HomestayChargeRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 充值记录表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-09-21 10:09:37
 */
@Mapper
public interface HomestayChargeRecordDao extends BaseMapper<HomestayChargeRecordEntity> {

    BigDecimal getChargeCount(Map<String,Object> params);
	
}
