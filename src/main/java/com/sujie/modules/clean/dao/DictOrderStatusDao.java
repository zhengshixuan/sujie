package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.DictOrderStatusEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单状态字典表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Mapper
public interface DictOrderStatusDao extends BaseMapper<DictOrderStatusEntity> {
	
}
