package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.DictCleanTypeEntity;

import java.util.Map;

/**
 * 保洁类型字典
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
public interface DictCleanTypeService extends IService<DictCleanTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

