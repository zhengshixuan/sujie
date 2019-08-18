package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.RoomNessitiesReminderDao;
import com.sujie.modules.clean.entity.RoomNessitiesReminderEntity;
import com.sujie.modules.clean.service.RoomNessitiesReminderService;


@Service("roomNessitiesReminderService")
public class RoomNessitiesReminderServiceImpl extends ServiceImpl<RoomNessitiesReminderDao, RoomNessitiesReminderEntity> implements RoomNessitiesReminderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoomNessitiesReminderEntity> page = this.page(
                new Query<RoomNessitiesReminderEntity>().getPage(params),
                new QueryWrapper<RoomNessitiesReminderEntity>()
        );

        return new PageUtils(page);
    }

}