package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.RoomInfoEntity;

import java.util.Map;

/**
 * 房间信息
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
public interface RoomInfoService extends IService<RoomInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

