package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.clean.entity.HomestayInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 民宿基本信息表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-17 09:35:24
 */
@Mapper
public interface HomestayInfoDao extends BaseMapper<HomestayInfoEntity> {
    /**
     * 查询所有的地址
     * @return
     */
    List<String> getAllWorkPlace();
	
}
