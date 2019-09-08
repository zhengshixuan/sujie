package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.OrderRecordDao;
import com.sujie.modules.clean.entity.OrderRecordEntity;
import com.sujie.modules.clean.service.OrderRecordService;


@Service("orderRecordService")
public class OrderRecordServiceImpl extends ServiceImpl<OrderRecordDao, OrderRecordEntity> implements OrderRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderRecordEntity> page = this.page(
                new Query<OrderRecordEntity>().getPage(params),
                new QueryWrapper<OrderRecordEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int updateRecordStatus(Map<String, Object> params) {
        baseMapper.updateRecordStatus(params);
        return 0;
    }

}