package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.StaffWorkPlaceDao;
import com.sujie.modules.clean.entity.StaffWorkPlaceEntity;
import com.sujie.modules.clean.service.StaffWorkPlaceService;


@Service("staffWorkPlaceService")
public class StaffWorkPlaceServiceImpl extends ServiceImpl<StaffWorkPlaceDao, StaffWorkPlaceEntity> implements StaffWorkPlaceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StaffWorkPlaceEntity> page = this.page(
                new Query<StaffWorkPlaceEntity>().getPage(params),
                new QueryWrapper<StaffWorkPlaceEntity>()
        );

        return new PageUtils(page);
    }

}