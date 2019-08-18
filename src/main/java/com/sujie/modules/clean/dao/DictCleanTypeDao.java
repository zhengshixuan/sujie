package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.DictCleanTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 保洁类型字典
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:20
 */
@Mapper
public interface DictCleanTypeDao extends BaseMapper<DictCleanTypeEntity> {
	
}
