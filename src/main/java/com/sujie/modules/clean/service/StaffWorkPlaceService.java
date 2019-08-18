package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.StaffWorkPlaceEntity;

import java.util.Map;

/**
 * 保洁阿姨工作位置
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface StaffWorkPlaceService extends IService<StaffWorkPlaceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

