package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.RoomNessitiesReminderEntity;

import java.util.List;
import java.util.Map;

/**
 * 一次性物品不足提醒表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:14
 */
public interface RoomNessitiesReminderService extends IService<RoomNessitiesReminderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过订单id查询房间缺少的必需品
     * @param params
     * @return
     */
    List<Map<String,Object>> getRoomNessitiesByOrderId(Map<String, Object> params);
}

