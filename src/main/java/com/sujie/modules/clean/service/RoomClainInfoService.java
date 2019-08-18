package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.RoomClainInfoEntity;

import java.util.Map;

/**
 * 房间内特殊信息显示
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
public interface RoomClainInfoService extends IService<RoomClainInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

