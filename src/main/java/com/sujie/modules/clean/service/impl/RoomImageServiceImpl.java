package com.sujie.modules.clean.service.impl;

import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;
import com.sujie.modules.clean.dao.RoomImageDao;
import com.sujie.modules.clean.entity.RoomImageEntity;
import com.sujie.modules.clean.service.RoomImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("roomImageService")
public class RoomImageServiceImpl extends ServiceImpl<RoomImageDao, RoomImageEntity> implements RoomImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoomImageEntity> page = this.page(
                new Query<RoomImageEntity>().getPage(params),
                new QueryWrapper<RoomImageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<RoomImageEntity> listByHomestayIdAndRoomId(Map<String, Object> params) {
        List<RoomImageEntity> roomImageEntities = baseMapper.selectByMap(params);
        return roomImageEntities;
    }

}