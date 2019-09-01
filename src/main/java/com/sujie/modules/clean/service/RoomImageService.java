package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.RoomImageEntity;

import java.util.List;
import java.util.Map;

/**
 * 房间图片信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-09-01 13:55:56
 */
public interface RoomImageService extends IService<RoomImageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RoomImageEntity> listByHomestayIdAndRoomId(Map<String, Object> params);
}

