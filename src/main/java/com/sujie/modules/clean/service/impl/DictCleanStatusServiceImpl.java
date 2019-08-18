package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.DictCleanStatusDao;
import com.sujie.modules.clean.entity.DictCleanStatusEntity;
import com.sujie.modules.clean.service.DictCleanStatusService;


@Service("dictCleanStatusService")
public class DictCleanStatusServiceImpl extends ServiceImpl<DictCleanStatusDao, DictCleanStatusEntity> implements DictCleanStatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictCleanStatusEntity> page = this.page(
                new Query<DictCleanStatusEntity>().getPage(params),
                new QueryWrapper<DictCleanStatusEntity>()
        );

        return new PageUtils(page);
    }

}