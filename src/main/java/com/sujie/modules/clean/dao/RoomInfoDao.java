package com.sujie.modules.clean.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.vo.RoomInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 房间信息
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:20
 */
@Repository
@Mapper
public interface RoomInfoDao extends BaseMapper<RoomInfoEntity> {

    IPage<RoomInfoVO> selectPageVo(IPage<RoomInfoVO> page,@Param("params")  Map<String,Object> params);


    Map<String, Object> getRoomInfoByHomestayIdANdRoomId(Map<String, Object> params);

    /**
     * 通过运营者手机号查询此民宿下所有房间信息
     * @param params
     * @return
     */
    List<Map<String,Object>> listRoomInfosByOperatorPhone(Map<String, Object> params);

    /**
     * 查询房间详细信息
     * @param params
     * @return
     */
    Map<String,Object> getRoomInfoDetail(Map<String,Object> params);





}
