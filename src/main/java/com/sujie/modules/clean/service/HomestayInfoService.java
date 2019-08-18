package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.HomestayInfoEntity;

import java.util.Map;

/**
 * 民宿基本信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
public interface HomestayInfoService extends IService<HomestayInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

