package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.RoomClainInfoDao;
import com.sujie.modules.clean.entity.RoomClainInfoEntity;
import com.sujie.modules.clean.service.RoomClainInfoService;


@Service("roomClainInfoService")
public class RoomClainInfoServiceImpl extends ServiceImpl<RoomClainInfoDao, RoomClainInfoEntity> implements RoomClainInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoomClainInfoEntity> page = this.page(
                new Query<RoomClainInfoEntity>().getPage(params),
                new QueryWrapper<RoomClainInfoEntity>()
        );

        return new PageUtils(page);
    }

}