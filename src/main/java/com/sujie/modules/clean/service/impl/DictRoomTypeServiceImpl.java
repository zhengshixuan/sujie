package com.sujie.modules.clean.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.DictRoomTypeDao;
import com.sujie.modules.clean.entity.DictRoomTypeEntity;
import com.sujie.modules.clean.service.DictRoomTypeService;


@Service("dictRoomTypeService")
public class DictRoomTypeServiceImpl extends ServiceImpl<DictRoomTypeDao, DictRoomTypeEntity> implements DictRoomTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DictRoomTypeEntity> page = this.page(
                new Query<DictRoomTypeEntity>().getPage(params),
                new QueryWrapper<DictRoomTypeEntity>()
        );

        return new PageUtils(page);
    }

}