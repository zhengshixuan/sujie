package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sujie.common.utils.Query;
import com.sujie.modules.clean.entity.RoomClainInfoEntity;
import com.sujie.modules.clean.vo.RoomInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;

import com.sujie.modules.clean.dao.RoomInfoDao;
import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.service.RoomInfoService;


@Service("roomInfoService")
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoDao, RoomInfoEntity> implements RoomInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

//
        IPage<RoomInfoVO> page = new Query<RoomInfoVO>().getPage(params);
//        Page<RoomInfoVO> page = new Page<RoomInfoVO>((Long) params.get("page"),(Long) params.get("limit"));
        IPage<RoomInfoVO> roomInfoVOIPage = baseMapper.selectPageVo(page, params);
        return new PageUtils(roomInfoVOIPage);
    }

}