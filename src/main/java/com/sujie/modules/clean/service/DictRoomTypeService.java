package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.DictRoomTypeEntity;

import java.util.Map;

/**
 * 房间类型字典表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface DictRoomTypeService extends IService<DictRoomTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

