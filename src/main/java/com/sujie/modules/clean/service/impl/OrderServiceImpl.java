package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.sujie.modules.clean.dao.OrderImageDao;
import com.sujie.modules.clean.dao.OrderRecordDao;
import com.sujie.modules.clean.dao.RoomInfoDao;
import com.sujie.modules.clean.entity.OrderImageEntity;
import com.sujie.modules.clean.service.OrderRecordService;
import com.sujie.modules.clean.service.StaffInfoService;
import com.sujie.modules.clean.vo.OrderVO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.OrderDao;
import com.sujie.modules.clean.entity.OrderEntity;
import com.sujie.modules.clean.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private StaffInfoService staffInfoService;
    @Autowired
    private OrderRecordService orderRecordService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomInfoDao roomInfoDao;
    @Autowired
    private OrderImageDao orderImageDao;

    @Override
    public List<Map<String, Object>> getOrdersByHomestayIdAndRoomId(Map<String, Object> params) {


        List<Map<String, Object>> list = baseMapper.getOrdersByHomestayIdAndRoomId(params);
        return list;
    }

    @Override
    public boolean updateOrder(Map<String, Object> params) {
        orderRecordService.updateRecordStatus(params);
        baseMapper.updateCleanStatusCode(params);
        return true;
    }

    @Override
    public List<Map<String, Object>> listPreOrderByStatus(Map<String, Object> params) {
        List<Map<String, Object>> mapList = baseMapper.listPreOrderByStatus(params);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> listOrderByStatus(Map<String, Object> params) {

        List<Map<String, Object>> list = baseMapper.listOrderByStatus(params);
        return list;
    }

    @Override
    public Map<String, Object> getTodayPreOrder(Map<String, Object> params) {
        Map<String, Object> map = staffInfoService.listStaffInfoByTelphone(params);
        if (null != map) {
            if (StringUtils.isNotBlank((String) map.get("address"))) {
                params.put("address", map.get("address"));
            }
        } else {
            params.put("address", "中南国际汇");
        }
        params.put("currentDate", SDF.format(new Date()));
        Integer preOrderCount = baseMapper.getPreOrderCount(params);//预派单数（总数）
//        params.put("cleanStatusCode", 1);
        Integer preOrderRemaininggCount = baseMapper.getPreOrderCount(params);//剩下的保洁单
        map.put("preDispatch", preOrderCount);
        map.put("restDsipatch", preOrderRemaininggCount);
        return map;
    }

    @Override
    public Map<String, Object> findOrderDetail(Map<String, Object> params) {
        Map<String, Object> roomInfoDetail = baseMapper.findRoomInfoDetail(params);

        return roomInfoDetail;
    }

    @Override
    public List<Map<String, Object>> listTodayOrder(Map<String, Object> params) {
        params.put("currentDate", SDF.format(new Date()));
        List<Map<String, Object>> todayOrderS = baseMapper.listTodayOrder(params);
        return todayOrderS;
    }

    @Override
    public PageUtils listRoomCleanRecord(Map<String, Object> params) {

        params.put("cleanStatusCode", 3);
        IPage<OrderVO> page = new Query<OrderVO>().getPage(params);
        IPage<OrderVO> orderVOIPage = baseMapper.listOrderVO(page, params);
        return new PageUtils(orderVOIPage);
    }

    @Override
    public List<Map<String, Object>> listRoomCleanRecordApp(Map<String, Object> params) {
        List<Map<String, Object>> list = baseMapper.listRoomCleanRecordApp(params);
        return list;
    }

    /**
     * 查询待保洁还未保洁的记录
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils listPrepareCleanOrder(Map<String, Object> params) {
        //订单状态
        params.put("cleanStatusCode", 1);
        //创建订单时间
        params.put("createDate", SDF.format(new Date()));
        IPage<OrderVO> page = new Query<OrderVO>().getPage(params);
        IPage<OrderVO> orderVOIPage = baseMapper.listOrderVO(page, params);
        return new PageUtils(orderVOIPage);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> listPreOrder(Map<String, Object> params) {
        List<Map<String, Object>> maps = baseMapper.listPreOrder(params);
        return maps;
    }

    @Override
    public Integer getPreorderCount(Map<String, Object> map) {
        Integer preparOrderCount = baseMapper.getPreparOrderCount(map);
        return preparOrderCount;
    }

    @Override
    public List<Map<String, Object>> listPreOrderDetail(Map<String, Object> map) {
        List<Map<String, Object>> maps = baseMapper.listPreOrderDetail(map);
        return maps;
    }

    @Override
    public List<Map<String, Object>> searchOrders(Map<String, Object> map) {
        List<Map<String, Object>> list = baseMapper.searchOrders(map);
        return list;
    }

    @Override
    public OrderEntity getOrder(Map<String, Object> map) {
        QueryWrapper<OrderEntity> orderQueryWrapper = new QueryWrapper<>();
        String homestayId = (String) map.get("homestayId");
        String roomNo = (String) map.get("roomNo");
        orderQueryWrapper.eq("homestay_id", homestayId);
        orderQueryWrapper.eq("room_id", roomNo);
        orderQueryWrapper.eq("clean_status_code", 0);
        orderQueryWrapper.eq("pre_start_clean_date", SDF.format(new Date()));
        OrderEntity orderEntity = baseMapper.selectOne(orderQueryWrapper);
        return orderEntity;
    }

    @Override
    public OrderEntity getOrderByOrderId(String orderId) {
        QueryWrapper<OrderEntity> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("order_id", orderId);
        OrderEntity orderEntity = baseMapper.selectOne(orderQueryWrapper);
        return orderEntity;
    }

    @Override
    public Map<String, Object> getComeleteOrder(Map<String, Object> params) {
        Map<String, Object> roomInfoDetail = roomInfoDao.getRoomInfoDetail(params);
        QueryWrapper<OrderImageEntity> orderImageEntityQueryWrapper = new QueryWrapper<>();
        orderImageEntityQueryWrapper.eq("order_id",params.get("orderId"));
        List<OrderImageEntity> orderImageEntities = orderImageDao.selectList(orderImageEntityQueryWrapper);
        if(null!=orderImageEntities&&orderImageEntities.size()>0){
            List<String> otherPitList = new ArrayList<>();
            List<String> bathRoomPitList = new ArrayList<>();
            for (OrderImageEntity orderImageEntity : orderImageEntities) {
                Map<String, Object> map = new HashMap<>();
                map.put("explain", orderImageEntity.getComments());
                if ("1".equals(orderImageEntity.getPicTypeCode().toString().toString())) {
                    map.put("bedPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("Area-bed", map);
                } else if ("2".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("livingRoomPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("Area-LivingRoom", map);
                } else if ("3".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("kitchenPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("Area-kitchen", map);
                } else if ("4".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("balconyPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("Area-balcony", map);
                } else if ("5".equals(orderImageEntity.getPicTypeCode().toString()) || "6".equals(orderImageEntity.getPicTypeCode().toString()) || "7".equals(orderImageEntity.getPicTypeCode().toString())) {
                    bathRoomPitList.add(orderImageEntity.getPath());
                    map.put("bathRoomPitUrlArr", bathRoomPitList.toArray());
                    roomInfoDetail.put("Area-bathRoom", map);
                } else if ("8".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("toothBrushPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-toothBrush", map);
                } else if ("9".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("shampooPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-shampoo", map);
                } else if ("10".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("comPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-comb", map);

                } else if ("11".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("toiletPaperPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-toiletPaper", map);
                } else if ("12".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("livingRoomPaperPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-livingRoomPaper", map);
                } else if ("13".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("bedSheetPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-bedsheet", map);
                } else if ("14".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("kitchenwarePitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-kitchenware", map);
                } else if ("15".equals(orderImageEntity.getPicTypeCode().toString())) {
                    map.put("rubbishBagPitUrl", orderImageEntity.getPath());
                    roomInfoDetail.put("custom-rubbishBag", map);
                } else if ("16".equals(orderImageEntity.getPicTypeCode().toString())) {
                    otherPitList.add(orderImageEntity.getPath());
                    map.put("otherPitUrlArr", otherPitList.toArray());
                    roomInfoDetail.put("Area-other", map);
                }

            }
        }

        return roomInfoDetail;
    }

    @Override
    public BigDecimal getConCount(Map<String, Object> params) {
        BigDecimal conCount = baseMapper.getConCount(params);

        return conCount;
    }
}