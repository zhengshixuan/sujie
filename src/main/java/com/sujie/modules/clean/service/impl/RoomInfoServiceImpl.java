package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sujie.common.utils.Query;
import com.sujie.modules.clean.entity.RoomClainInfoEntity;
import com.sujie.modules.clean.service.*;
import com.sujie.modules.clean.vo.RoomInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;

import com.sujie.modules.clean.dao.RoomInfoDao;
import com.sujie.modules.clean.entity.RoomInfoEntity;


@Service("roomInfoService")
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoDao, RoomInfoEntity> implements RoomInfoService {
    @Autowired
    private DictDailyNessitiesService dictDailyNessitiesService;
    @Autowired
    private RoomImageService roomImageService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderImageService orderImageService;
    @Autowired
    private RoomNessitiesReminderService roomNessitiesReminderService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

//
        IPage<RoomInfoVO> page = new Query<RoomInfoVO>().getPage(params);
//        Page<RoomInfoVO> page = new Page<RoomInfoVO>((Long) params.get("page"),(Long) params.get("limit"));
        IPage<RoomInfoVO> roomInfoVOIPage = baseMapper.selectPageVo(page, params);
        return new PageUtils(roomInfoVOIPage);
    }

    @Override
    public Map<String, Object> getRoomInfoByHomestayIdANdRoomId(Map<String, Object> params) {
        //民宿基本信息
        Map<String, Object> roomInfo = baseMapper.getRoomInfoByHomestayIdANdRoomId(params);

        List<Map<String, Object>> orderList = orderService.getOrdersByHomestayIdAndRoomId(params);
        List<Map<String, Object>> orderImageList = null;
        List<Map<String, Object>> nessitiesList = null;
        if (null != orderList && orderList.size() > 0) {
            //查询最近的一次保洁记录
            Map<String, Object> map = orderList.get(0);
            roomInfo.put("comments", map.get("comments"));
            roomInfo.put("cleanTypeName", map.get("cleanTypeName"));
            String orderId = (String) map.get("orderId");
            params.put("orderId", orderId);
            //查询图片信息
            orderImageList = orderImageService.findOrderImageByOrderId(params);
            //查询缺少的物品信息
            nessitiesList = roomNessitiesReminderService.getRoomNessitiesByOrderId(params);

        } else {
            orderImageList = new LinkedList<>();
            Map<String, Object> imgMap = new HashMap<>();
            imgMap.put("path", "../../images/logo.png");
            imgMap.put("item_code", "16");
            orderImageList.add(imgMap);
            nessitiesList = dictDailyNessitiesService.listMaps();
            roomInfo.put("cleanTypeName", "普通保洁");
        }
        roomInfo.put("image", orderImageList);
        roomInfo.put("nessitiesList", nessitiesList);
        return roomInfo;
    }

    @Override
    public List<Map<String, Object>> getRoomInfos(Map<String, Object> params) {

        return baseMapper.listRoomInfosByOperatorPhone(params);
    }


}