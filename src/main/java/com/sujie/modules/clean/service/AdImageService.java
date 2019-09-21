package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.modules.clean.entity.AdImageEntity;

import java.util.List;
import java.util.Map;

public interface AdImageService extends IService<AdImageEntity> {

    /**
     * 查询循环展示的图片信息,返回url和描述信息
     * @return
     */
    List<Map<String,Object>> listPic();

}

