package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.DictCleanStatusEntity;

import java.util.Map;

/**
 * 打扫状态字典
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface DictCleanStatusService extends IService<DictCleanStatusEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

