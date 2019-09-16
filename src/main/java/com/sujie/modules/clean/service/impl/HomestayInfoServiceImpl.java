package com.sujie.modules.clean.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        QueryWrapper<HomestayInfoEntity> queryWrapper = new QueryWrapper<HomestayInfoEntity>();
        if (StringUtils.isNotBlank((String) params.get("homestayName"))) {
            queryWrapper.like("homestay_name", params.get("homestayName"));
        }
        if (StringUtils.isNotBlank((String) params.get("operatorsName"))) {
            queryWrapper.like("operators_name", params.get("operatorsName"));
        }


        IPage<HomestayInfoEntity> page = this.page(
                new Query<HomestayInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> getAllWorkPalce() {
        List<String> allWorkPlace = baseMapper.getAllWorkPlace();
        return allWorkPlace;
    }

    @Override
    public Map<String, Object> getHomestayInfoDetail(Map<String, Object> params) {
        Map<String, Object> homestayInfoDetail = baseMapper.getHomestayInfoDetail(params);
        return homestayInfoDetail;
    }

}