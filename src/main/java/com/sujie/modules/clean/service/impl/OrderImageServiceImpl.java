package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.OrderImageDao;
import com.sujie.modules.clean.entity.OrderImageEntity;
import com.sujie.modules.clean.service.OrderImageService;


@Service("orderImageService")
public class OrderImageServiceImpl extends ServiceImpl<OrderImageDao, OrderImageEntity> implements OrderImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderImageEntity> page = this.page(
                new Query<OrderImageEntity>().getPage(params),
                new QueryWrapper<OrderImageEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> findOrderImageByOrderId(Map<String, Object> params) {
        List<Map<String, Object>> imageList = baseMapper.findOrderImageByOrderId(params);

        return imageList;
    }

}