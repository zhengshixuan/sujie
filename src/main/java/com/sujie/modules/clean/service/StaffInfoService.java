package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.StaffInfoEntity;

import java.util.Map;

/**
 * 保洁阿姨信息
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface StaffInfoService extends IService<StaffInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

