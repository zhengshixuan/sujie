package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.DictDailyNessitiesEntity;

import java.util.Map;

/**
 * 日用品字典表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface DictDailyNessitiesService extends IService<DictDailyNessitiesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

