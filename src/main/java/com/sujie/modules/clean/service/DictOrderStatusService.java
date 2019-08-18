package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.DictOrderStatusEntity;

import java.util.Map;

/**
 * 订单状态字典表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface DictOrderStatusService extends IService<DictOrderStatusEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

