package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.RoomInfoDao;
import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.service.RoomInfoService;


@Service("roomInfoService")
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoDao, RoomInfoEntity> implements RoomInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoomInfoEntity> page = this.page(
                new Query<RoomInfoEntity>().getPage(params),
                new QueryWrapper<RoomInfoEntity>()
        );

        return new PageUtils(page);
    }

}