package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.AdImageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdImageDao extends BaseMapper<AdImageEntity> {
    List<Map<String,Object>> listPic();
}
