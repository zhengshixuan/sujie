package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.StaffCommissionDao;
import com.sujie.modules.clean.entity.StaffCommissionEntity;
import com.sujie.modules.clean.service.StaffCommissionService;


@Service("staffCommissionService")
public class StaffCommissionServiceImpl extends ServiceImpl<StaffCommissionDao, StaffCommissionEntity> implements StaffCommissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StaffCommissionEntity> page = this.page(
                new Query<StaffCommissionEntity>().getPage(params),
                new QueryWrapper<StaffCommissionEntity>()
        );

        return new PageUtils(page);
    }

}