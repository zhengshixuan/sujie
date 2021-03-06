package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.RoomInfoEntity;

import java.util.List;
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


    /**
     * 通过民宿id和房间号查询房间信息
     * @param params
     * @return
     */
    Map<String,Object> getRoomInfoByHomestayIdANdRoomId(Map<String, Object> params);


    /**
     * 查询房间信息
     * @param params
     * @return homeStayBreand 民宿品牌 address 民宿地址 roomNo 房间号
     */
    List<Map<String,Object>> getRoomInfos(Map<String,Object> params);

    /**
     * 查询房间详细信息,老板端使用
     * @param params
     * @return
     */
    Map<String,Object> getRoomInfoDetail(Map<String,Object> params);

}

