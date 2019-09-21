package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.HomestayChargeRecordDao;
import com.sujie.modules.clean.entity.HomestayChargeRecordEntity;
import com.sujie.modules.clean.service.HomestayChargeRecordService;


@Service("homestayChargeRecordService")
public class HomestayChargeRecordServiceImpl extends ServiceImpl<HomestayChargeRecordDao, HomestayChargeRecordEntity> implements HomestayChargeRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomestayChargeRecordEntity> page = this.page(
                new Query<HomestayChargeRecordEntity>().getPage(params),
                new QueryWrapper<HomestayChargeRecordEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public BigDecimal getChargeCount(Map<String, Object> params) {
        BigDecimal chargeCount = baseMapper.getChargeCount(params);

        return chargeCount;
    }

}