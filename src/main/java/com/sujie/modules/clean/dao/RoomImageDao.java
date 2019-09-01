package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.RoomImageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 房间图片信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-09-01 13:55:56
 */
@Mapper
public interface RoomImageDao extends BaseMapper<RoomImageEntity> {
	
}
