package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.RoomNessitiesReminderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 一次性物品不足提醒表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:18
 */
@Mapper
public interface RoomNessitiesReminderDao extends BaseMapper<RoomNessitiesReminderEntity> {

    /**
     * 查询缺少的物品名称和代码
     * @param params
     * @return
     */
    List<Map<String,Object>> getRoomNessitiesByOrderId(Map<String, Object> params);
	
}
