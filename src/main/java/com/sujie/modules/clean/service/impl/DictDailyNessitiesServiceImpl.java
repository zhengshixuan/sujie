package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.DictDailyNessitiesDao;
import com.sujie.modules.clean.entity.DictDailyNessitiesEntity;
import com.sujie.modules.clean.service.DictDailyNessitiesService;


@Service("dictDailyNessitiesService")
public class DictDailyNessitiesServiceImpl extends ServiceImpl<DictDailyNessitiesDao, DictDailyNessitiesEntity> implements DictDailyNessitiesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictDailyNessitiesEntity> page = this.page(
                new Query<DictDailyNessitiesEntity>().getPage(params),
                new QueryWrapper<DictDailyNessitiesEntity>()
        );

        return new PageUtils(page);
    }

}