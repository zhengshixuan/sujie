package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.RoomNessitiesReminderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 一次性物品不足提醒表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:18
 */
@Mapper
public interface RoomNessitiesReminderDao extends BaseMapper<RoomNessitiesReminderEntity> {
	
}
