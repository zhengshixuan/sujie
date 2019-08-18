package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.StaffInfoDao;
import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;


@Service("staffInfoService")
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoDao, StaffInfoEntity> implements StaffInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StaffInfoEntity> page = this.page(
                new Query<StaffInfoEntity>().getPage(params),
                new QueryWrapper<StaffInfoEntity>()
        );

        return new PageUtils(page);
    }

}