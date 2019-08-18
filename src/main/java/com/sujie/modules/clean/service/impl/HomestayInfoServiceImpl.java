package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.HomestayInfoDao;
import com.sujie.modules.clean.entity.HomestayInfoEntity;
import com.sujie.modules.clean.service.HomestayInfoService;


@Service("homestayInfoService")
public class HomestayInfoServiceImpl extends ServiceImpl<HomestayInfoDao, HomestayInfoEntity> implements HomestayInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomestayInfoEntity> page = this.page(
                new Query<HomestayInfoEntity>().getPage(params),
                new QueryWrapper<HomestayInfoEntity>()
        );

        return new PageUtils(page);
    }

}