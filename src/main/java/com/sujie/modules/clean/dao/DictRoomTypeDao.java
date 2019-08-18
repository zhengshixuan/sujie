package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.DictRoomTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房间类型字典表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Mapper
public interface DictRoomTypeDao extends BaseMapper<DictRoomTypeEntity> {
	
}
