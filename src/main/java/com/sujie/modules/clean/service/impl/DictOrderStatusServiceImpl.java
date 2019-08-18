package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.DictOrderStatusDao;
import com.sujie.modules.clean.entity.DictOrderStatusEntity;
import com.sujie.modules.clean.service.DictOrderStatusService;


@Service("dictOrderStatusService")
public class DictOrderStatusServiceImpl extends ServiceImpl<DictOrderStatusDao, DictOrderStatusEntity> implements DictOrderStatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictOrderStatusEntity> page = this.page(
                new Query<DictOrderStatusEntity>().getPage(params),
                new QueryWrapper<DictOrderStatusEntity>()
        );

        return new PageUtils(page);
    }

}