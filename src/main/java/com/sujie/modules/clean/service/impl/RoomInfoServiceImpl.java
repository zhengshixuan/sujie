package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sujie.common.utils.Query;
import com.sujie.modules.clean.entity.RoomClainInfoEntity;
import com.sujie.modules.clean.entity.RoomImageEntity;
import com.sujie.modules.clean.service.*;
import com.sujie.modules.clean.vo.RoomInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
            if(null==orderImageList||orderImageList.size()==0){
                Map<String, Object> imgMap = new HashMap<>();
                imgMap.put("path", "../../images/logo.png");
                imgMap.put("item_code", "16");
                orderImageList.add(imgMap);
                nessitiesList = dictDailyNessitiesService.listMaps();
            }
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

    @Override
    public Map<String, Object> getRoomInfoDetail(Map<String, Object> params) {
        Map<String, Object> roomInfoDetail = baseMapper.getRoomInfoDetail(params);
        if (null != roomInfoDetail) {
            List<RoomImageEntity> roomImageEntities = roomImageService.listRoomImage(params);
            if (null != roomImageEntities && roomImageEntities.size() > 0) {
                List<String> otherPitList = new ArrayList<>();
                List<String> bathRoomPitList = new ArrayList<>();
                for (RoomImageEntity image : roomImageEntities) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("explain", image.getComments());
                    if ("1".equals(image.getPicTypeCode().toString().toString())) {
                        map.put("bedPitUrl", image.getPicPath());
                        roomInfoDetail.put("areaBed", map);
                    } else if ("2".equals(image.getPicTypeCode().toString())) {
                        map.put("livingRoomPitUrl", image.getPicPath());
                        roomInfoDetail.put("areaLivingRoom", map);
                    } else if ("3".equals(image.getPicTypeCode().toString())) {
                        map.put("kitchenPitUrl", image.getPicPath());
                        roomInfoDetail.put("areaKitchen", map);
                    } else if ("4".equals(image.getPicTypeCode().toString())) {
                        map.put("balconyPitUrl", image.getPicPath());
                        roomInfoDetail.put("areaBalcony", map);
                    } else if ("5".equals(image.getPicTypeCode().toString()) || "6".equals(image.getPicTypeCode().toString()) || "7".equals(image.getPicTypeCode().toString())) {
                        bathRoomPitList.add(image.getPicPath());
                        map.put("bathRoomPitUrlArr", bathRoomPitList.toArray());
                        roomInfoDetail.put("areaBathRoom", map);
                    } else if ("8".equals(image.getPicTypeCode().toString())) {
                        map.put("toothBrushPitUrl", image.getPicPath());
                        roomInfoDetail.put("customToothBrush", map);
                    } else if ("9".equals(image.getPicTypeCode().toString())) {
                        map.put("shampooPitUrl", image.getPicPath());
                        roomInfoDetail.put("customShampoo", map);
                    } else if ("10".equals(image.getPicTypeCode().toString())) {
                        map.put("comPitUrl", image.getPicPath());
                        roomInfoDetail.put("customComb", map);

                    } else if ("11".equals(image.getPicTypeCode().toString())) {
                        map.put("toiletPaperPitUrl", image.getPicPath());
                        roomInfoDetail.put("customToiletPaper", map);
                    } else if ("12".equals(image.getPicTypeCode().toString())) {
                        map.put("livingRoomPaperPitUrl", image.getPicPath());
                        roomInfoDetail.put("customLivingRoomPaper", map);
                    } else if ("13".equals(image.getPicTypeCode().toString())) {
                        map.put("bedSheetPitUrl", image.getPicPath());
                        roomInfoDetail.put("customBedsheet", map);
                    } else if ("14".equals(image.getPicTypeCode().toString())) {
                        map.put("kitchenwarePitUrl", image.getPicPath());
                        roomInfoDetail.put("customKitchenware", map);
                    } else if ("15".equals(image.getPicTypeCode().toString())) {
                        map.put("rubbishBagPitUrl", image.getPicPath());
                        roomInfoDetail.put("customRubbishBag", map);
                    } else if ("16".equals(image.getPicTypeCode().toString())) {
                        otherPitList.add(image.getPicPath());
                        map.put("otherPitUrlArr", otherPitList.toArray());
                        roomInfoDetail.put("areaOther", map);
                    }

                }

            }
            String[] keys = {"areaBed", "areaLivingRoom", "areaKitchen", "areaBalcony", "areaBathRoom", "customToothBrush",
                    "customShampoo", "customComb", "customToiletPaper", "customLivingRoomPaper", "customBedsheet", "customKitchenware", "customRubbishBag", "areaOther"};
            String[] mapKesys = {"bedPitUrl", "livingRoomPitUrl", "kitchenPitUrl", "balconyPitUrl", "bathRoomPitUrlArr", "toothBrushPitUrl", "shampooPitUrl", "comPitUrl",
                    "toiletPaperPitUrl", "livingRoomPaperPitUrl", "bedSheetPitUrl", "kitchenwarePitUrl", "rubbishBagPitUrl", "otherPitUrlArr"};
            for (int i = 0; i < keys.length; i++) {
                if (!roomInfoDetail.containsKey(keys[i])) {
                    Map<String, Object> map = new HashMap<>();
                    if (keys[i].equals("areaBathRoom") || keys[i].equals("areaOther")) {
                        map.put(mapKesys[i], new String[0]);
                    } else {
                        map.put(mapKesys[i], "");
                    }
                    map.put("explain", "");
                    roomInfoDetail.put(keys[i], map);
                }
            }
        } else {
            roomInfoDetail = new HashMap<>();
        }
        return roomInfoDetail;
    }


}