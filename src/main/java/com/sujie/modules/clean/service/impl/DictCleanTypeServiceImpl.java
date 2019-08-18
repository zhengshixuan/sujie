package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.DictCleanTypeDao;
import com.sujie.modules.clean.entity.DictCleanTypeEntity;
import com.sujie.modules.clean.service.DictCleanTypeService;


@Service("dictCleanTypeService")
public class DictCleanTypeServiceImpl extends ServiceImpl<DictCleanTypeDao, DictCleanTypeEntity> implements DictCleanTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictCleanTypeEntity> page = this.page(
                new Query<DictCleanTypeEntity>().getPage(params),
                new QueryWrapper<DictCleanTypeEntity>()
        );

        return new PageUtils(page);
    }

}