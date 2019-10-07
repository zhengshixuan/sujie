package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.fabric.xmlrpc.base.Params;
import com.sujie.common.config.Trans;
import com.sujie.common.utils.*;
import com.sujie.modules.clean.dao.OrderDao;
import com.sujie.modules.clean.dao.OrderImageDao;
import com.sujie.modules.clean.dao.OrderRecordDao;
import com.sujie.modules.clean.dao.RoomInfoDao;
import com.sujie.modules.clean.entity.OrderEntity;
import com.sujie.modules.clean.entity.OrderImageEntity;
import com.sujie.modules.clean.entity.OrderRecordEntity;
import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.service.OrderRecordService;
import com.sujie.modules.clean.service.OrderService;
import com.sujie.modules.clean.service.StaffInfoService;
import com.sujie.modules.clean.vo.OrderVO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("orderService")
@Transactional(rollbackFor = Exception.class)
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
    @Autowired
    private OrderRecordDao orderRecordDao;

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
//        params.put("cleanStatusCode", 1);
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
        String preStartCleanDate = (String) map.get("preStartCleanDate");
        Integer cleanStatusCode = (Integer) map.get("cleanStatusCode");
        orderQueryWrapper.eq("homestay_id", homestayId);
        orderQueryWrapper.eq("room_id", roomNo);
        orderQueryWrapper.eq("clean_status_code", cleanStatusCode);
        orderQueryWrapper.eq("DATE_FORMAT(pre_start_clean_date,'%Y-%m-%d')", preStartCleanDate);
        OrderEntity orderEntity = baseMapper.selectOne(orderQueryWrapper);
        return orderEntity;
    }

    @Override
    public OrderEntity getOrderByHomestayIdANdRoomIdAndStatusCode(Map<String, Object> params) {
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("homestay_id", params.get("homestayId"))
                .eq("room_id", params.get("roomId"))
                .eq("clean_status_code", params.get("cleanStatusCode"))
                .eq("DATE_FORMAT(pre_start_clean_date,'%Y-%m-%d')", params.get("preStartCleanDate"));
        OrderEntity one = this.getOne(queryWrapper);
        return one;
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
        if (null != roomInfoDetail) {
            QueryWrapper<OrderImageEntity> orderImageEntityQueryWrapper = new QueryWrapper<>();
            orderImageEntityQueryWrapper.eq("order_id", params.get("orderId"));
            List<OrderImageEntity> orderImageEntities = orderImageDao.selectList(orderImageEntityQueryWrapper);
            if (null != orderImageEntities && orderImageEntities.size() > 0) {
                List<String> otherPitList = new ArrayList<>();
                List<String> bathRoomPitList = new ArrayList<>();
                for (OrderImageEntity orderImageEntity : orderImageEntities) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("explain", orderImageEntity.getComments());
                    if ("1".equals(orderImageEntity.getPicTypeCode().toString().toString())) {
                        map.put("bedPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("areaBed", map);
                    } else if ("2".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("livingRoomPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("areaLivingRoom", map);
                    } else if ("3".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("kitchenPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("areaKitchen", map);
                    } else if ("4".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("balconyPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("areaBalcony", map);
                    } else if ("5".equals(orderImageEntity.getPicTypeCode().toString()) || "6".equals(orderImageEntity.getPicTypeCode().toString()) || "7".equals(orderImageEntity.getPicTypeCode().toString())) {
                        bathRoomPitList.add(orderImageEntity.getPath());
                        map.put("bathRoomPitUrlArr", bathRoomPitList.toArray());
                        roomInfoDetail.put("areaBathRoom", map);
                    } else if ("8".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("toothBrushPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customToothBrush", map);
                    } else if ("9".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("shampooPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customShampoo", map);
                    } else if ("10".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("comPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customComb", map);
                    } else if ("11".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("toiletPaperPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customToiletPaper", map);
                    } else if ("12".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("livingRoomPaperPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customLivingRoomPaper", map);
                    } else if ("13".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("bedSheetPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customBedsheet", map);
                    } else if ("14".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("kitchenwarePitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customKitchenware", map);
                    } else if ("15".equals(orderImageEntity.getPicTypeCode().toString())) {
                        map.put("rubbishBagPitUrl", orderImageEntity.getPath());
                        roomInfoDetail.put("customRubbishBag", map);
                    } else if ("16".equals(orderImageEntity.getPicTypeCode().toString())) {
                        otherPitList.add(orderImageEntity.getPath());
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

    @Override
    public BigDecimal getConCount(Map<String, Object> params) {
        BigDecimal conCount = baseMapper.getConCount(params);

        return conCount;
    }


    @Override
    public R saveOrder(Map<String, Object> params) {

        String homestayId = (String) params.get("homestayId"); //民宿id
        String roomNo = (String) params.get("roomNo");//房间号
        String homeStayBreand = (String) params.get("homeStayBreand");//民宿名称
        String address = (String) params.get("address");//民宿地址
        String clearStart = (String) params.get("clearStart");//开始保洁时间
        String clearEnd = (String) params.get("clearEnd");//结束保洁时间
        String clearType = (String) params.get("clearType");//保洁类型
        String ischeckOut = (String) params.get("ischeckOut");//是否退房
        String comments = (String) params.get("comments");//描述
        String roomPassword = (String) params.get("roomPassword");//房间密码
        String orderCost = (String) params.get("orderCost");//老板填写的保洁费用

        if (StringUtils.isNotBlank(homestayId)) {
            if (StringUtils.isNotBlank(homeStayBreand)) {
                if (StringUtils.isNotBlank(address)) {
                    if (StringUtils.isNotBlank(roomNo)) {
                        if (StringUtils.isNotBlank(clearStart)) {
                            if (StringUtils.isNotBlank(clearEnd)) {
                                if (StringUtils.isNotBlank(clearType)) {
                                    if (StringUtils.isNotBlank(ischeckOut)) {
                                        if (StringUtils.isNotBlank(roomPassword)) {

                                            //预保洁每天
                                            List<String> dateList = null;
                                            try {
                                                Date startDate = SDF.parse(clearStart);
                                                Date endDate = SDF.parse(clearEnd);
                                                dateList = DateUtils.getBetweenDates(startDate, endDate);
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                                return R.error(0, "请输入正确的日期格式yyyy-MM-dd hh:mm");
                                            }

                                            if (null != dateList && dateList.size() > 0) {
                                                if (dateList.size() > 1) {
                                                    return R.error(0, "日期错误,开始日期和结束日期仅允许一天");
                                                } else {
                                                    QueryWrapper<RoomInfoEntity> roomInfoEntityQueryWrapper = new QueryWrapper<RoomInfoEntity>();
                                                    roomInfoEntityQueryWrapper.eq("homestay_id", homestayId);
                                                    roomInfoEntityQueryWrapper.eq("room_id", roomNo);
                                                    //房间信息
                                                    RoomInfoEntity roomInfo = roomInfoDao.selectOne(roomInfoEntityQueryWrapper);
                                                    if (null == roomInfo) {
                                                        return R.error(0, "未找到对应房间信息,请输入正确的民宿id和房间号");
                                                    } else {
                                                        for (String preStartCleanDate : dateList) {
                                                            //查询是否有待保洁的订单
                                                            params.put("preStartCleanDate", preStartCleanDate);
                                                            params.put("cleanStatusCode", 1);
                                                            OrderEntity orderEntity = this.getOrder(params);
                                                            if (orderEntity == null) {
                                                                // 查询状态为预保洁的订单,及状态为0
                                                                params.put("cleanStatusCode", 0);
                                                                OrderEntity preOrderEntity = this.getOrder(params);
                                                                //判断是否有预排单信息,如果有直接更新即可
                                                                if (null != preOrderEntity) {
                                                                    //通过订单号查询订单详细信息
                                                                    OrderRecordEntity orderRecordEntity = orderRecordService.getOrderRecordByOrderId(preOrderEntity.getOrderId());

                                                                    // 未查询到详细订单信息,直接保存
                                                                    if (orderRecordEntity == null) {
                                                                        orderRecordEntity = new OrderRecordEntity();
                                                                        orderRecordEntity.setOrderId(preOrderEntity.getOrderId());
                                                                        orderRecordEntity.setIsFirst(1);
                                                                        orderRecordEntity.setIsExtraBed(roomInfo.getIsExtraBed());
                                                                        orderRecordEntity.setBossCost(roomInfo.getPrice());
                                                                        orderRecordEntity.setStatus(0);
                                                                        orderRecordEntity.setComments(comments);
                                                                        orderRecordDao.insert(orderRecordEntity);
                                                                    } else {
                                                                        orderRecordEntity.setComments(comments);
                                                                        orderRecordDao.updateById(orderRecordEntity);
                                                                    }
                                                                    // TODO 暂时默认当天日期
                                                                    preOrderEntity.setPreStartCleanDate(preStartCleanDate + " 00:00");
                                                                    preOrderEntity.setPreEndCleanDate(preStartCleanDate + " 23:59");
                                                                    preOrderEntity.setCleanType(Integer.valueOf(clearType));
                                                                    preOrderEntity.setIsCheckOut(Integer.valueOf(ischeckOut));
                                                                    preOrderEntity.setCleanStatusCode(1);
                                                                    if (StringUtils.isNotBlank(orderCost)) {
                                                                        BigDecimal orderCostBigDecimal = new BigDecimal(orderCost);
                                                                        preOrderEntity.setOrderCost(orderCostBigDecimal);
                                                                    }
                                                                    preOrderEntity.setRoomPassword(roomPassword);

                                                                    //已经下过订单则只做更新处理
                                                                    this.updateById(preOrderEntity);
                                                                } else {
                                                                    //没有预排单信息,新建订单
                                                                    //订单表
                                                                    orderEntity = new OrderEntity();

                                                                    //订单详细表
                                                                    OrderRecordEntity orderRecordEntity = new OrderRecordEntity();

                                                                    orderEntity.setOrderId(OrderUtils.getOrderId());
                                                                    orderEntity.setHomestayId(homestayId);
                                                                    orderEntity.setCleanStatusCode(1);
                                                                    orderEntity.setRoomId(roomNo);
                                                                    orderEntity.setCleanType(Trans.trans(Integer.valueOf(clearType)));
                                                                    orderEntity.setIsCheckOut(Trans.trans(Integer.valueOf(ischeckOut)));
                                                                    // TODO 暂时默认当天日期
                                                                    orderEntity.setPreStartCleanDate(preStartCleanDate + " 00:00");
                                                                    orderEntity.setPreEndCleanDate(preStartCleanDate + " 23:59");
                                                                    orderEntity.setCreateDate(SDF.format(new Date()));
                                                                    if (StringUtils.isNotBlank(orderCost)) {
                                                                        BigDecimal orderCostBigDecimal = new BigDecimal(orderCost);
                                                                        orderEntity.setOrderCost(orderCostBigDecimal);
                                                                    }
                                                                    orderEntity.setRoomPassword(roomPassword);

                                                                    orderRecordEntity.setBossCost(roomInfo.getPrice());
                                                                    orderRecordEntity.setOrderId(orderEntity.getOrderId());
                                                                    orderRecordEntity.setIsFirst(1);
                                                                    orderRecordEntity.setIsExtraBed(roomInfo.getIsExtraBed());
                                                                    orderRecordEntity.setStatus(0);
                                                                    orderRecordEntity.setComments(comments);
                                                                    try {
                                                                        orderRecordDao.insert(orderRecordEntity);
                                                                        baseMapper.insert(orderEntity);
                                                                    } catch (Exception e) {
                                                                        e.printStackTrace();
                                                                        //回滚事务
                                                                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                                                                        return R.error(0, "保存失败");
                                                                    }

                                                                }
                                                            } else {
                                                                try {
                                                                    throw new RuntimeException("存在日期相同订单");
                                                                } catch (RuntimeException e) {
                                                                } finally {
                                                                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                                                                    return R.error(0, "存在日期相同订单");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                return R.error(0, "预打扫日期不正确");
                                            }
                                        } else {
                                            return R.error(0, "房间密码不能为空");
                                        }
                                    } else {
                                        return R.error(0, "是否退房不能为空");
                                    }
                                } else {
                                    return R.error(0, "保洁类型不能为空");
                                }
                            } else {
                                return R.error(0, "保洁结束时间不能为空");
                            }
                        } else {
                            return R.error(0, "保洁开始时间不能为空");
                        }
                    } else {
                        return R.error(0, "房间号不能为空");
                    }
                } else {
                    return R.error(0, "民宿地址不能为空");
                }
            } else {
                return R.error(0, "民宿名称不能为空");
            }
        } else {
            return R.error(0, "民宿id不能为空");
        }
        return R.appOK();
    }

    @Override
    public R savePreOrder(Map<String, Object> params) {
        String homestayId = (String) params.get("homestayId");
        String homeStayBreand = (String) params.get("homeStayBreand");
        String address = (String) params.get("address");
        String roomNo = (String) params.get("roomNo");
        String clearStart = (String) params.get("clearStart");
        String clearEnd = (String) params.get("clearEnd");
        String clearType = (String) params.get("clearType");
        String ischeckOut = (String) params.get("ischeckOut");
        String comments = (String) params.get("comments");

        if (StringUtils.isNotBlank(homestayId)) {
            if (StringUtils.isNotBlank(homeStayBreand)) {
                if (StringUtils.isNotBlank(address)) {
                    if (StringUtils.isNotBlank(roomNo)) {
                        if (StringUtils.isNotBlank(clearStart)) {
                            if (StringUtils.isNotBlank(clearEnd)) {
                                if (StringUtils.isNotBlank(clearType)) {
                                    if (StringUtils.isNotBlank(ischeckOut)) {
                                        //预保洁每天
                                        List<String> dateList = null;
                                        try {
                                            Date startDate = SDF.parse(clearStart);
                                            Date endDate = SDF.parse(clearEnd);
                                            dateList = DateUtils.getBetweenDates(startDate, endDate);
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                            return R.error(0, "请输入正确的日期格式yyyy-MM-dd hh:mm");
                                        }
                                        if (null != dateList && dateList.size() > 0) {
                                            // 目前要求只支持下一天订单,包含多天日期时返回错误
                                            if (dateList.size() > 1) {
                                                return R.error(0, "日期错误,开始日期和结束日期仅允许一天");
                                            } else {

                                                //房间信息
                                                QueryWrapper<RoomInfoEntity> roomInfoEntityQueryWrapper = new QueryWrapper<RoomInfoEntity>();
                                                roomInfoEntityQueryWrapper.eq("homestay_id", homestayId);
                                                roomInfoEntityQueryWrapper.eq("room_id", roomNo);
                                                // 获取房间新信息
                                                RoomInfoEntity roomInfo = roomInfoDao.selectOne(roomInfoEntityQueryWrapper);
                                                if (null == roomInfo) {
                                                    return R.error(0, "未找到对应房间信息,请输入正确的民宿id和房间号");
                                                } else {
                                                    Map<String, Object> map = new HashMap<>();
                                                    map.put("homestayId", homestayId);
                                                    map.put("roomId", roomNo);
                                                    map.put("cleanStatusCode", 0);
                                                    for (String preStartCleanDate : dateList) {
                                                        // 添加预打扫日期
                                                        map.put("preStartCleanDate", preStartCleanDate);

                                                        // 只查询为预保洁的订单
                                                        OrderEntity orderEntity = getOrderByHomestayIdANdRoomIdAndStatusCode(map);
                                                        OrderRecordEntity orderRecordEntity = null;
                                                        if (null == orderEntity) {
                                                            //订单表
                                                            orderEntity = new OrderEntity();
                                                            orderEntity.setOrderId(OrderUtils.getOrderId());
                                                            orderEntity.setHomestayId(homestayId);
                                                            orderEntity.setRoomId(roomNo);
                                                            orderEntity.setCleanStatusCode(0);
                                                            orderEntity.setCreateDate(SDF.format(new Date()));
                                                            orderEntity.setCleanType(Trans.trans(Integer.valueOf(clearType)));
                                                            orderEntity.setIsCheckOut(Trans.trans(Integer.valueOf(ischeckOut)));
                                                            // TODO 暂时默认为当前日期
                                                            orderEntity.setPreStartCleanDate(preStartCleanDate + " 00:00");
                                                            orderEntity.setPreEndCleanDate(preStartCleanDate + " 23:59");


                                                            //订单记录表
                                                            orderRecordEntity = new OrderRecordEntity();
                                                            orderRecordEntity.setOrderId(orderEntity.getOrderId());
                                                            orderRecordEntity.setBossCost(roomInfo.getPrice());
                                                            orderRecordEntity.setIsFirst(1);
                                                            orderRecordEntity.setIsExtraBed(roomInfo.getIsExtraBed());
                                                            orderRecordEntity.setStatus(0);
                                                            orderRecordEntity.setComments(comments);
                                                            baseMapper.insert(orderEntity);
                                                            orderRecordDao.insert(orderRecordEntity);
                                                        } else {
                                                            try {
                                                                throw new RuntimeException("存在日期相同订单");
                                                            } catch (RuntimeException e) {
                                                            } finally {
                                                                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                                                                return R.error(0, "存在日期相同订单");
                                                            }
//                                                        orderEntity.setCreateDate(SDF.format(new Date()));
//                                                        orderEntity.setCleanType(Trans.trans(Integer.valueOf(clearType)));
//                                                        orderEntity.setIsCheckOut(Trans.trans(Integer.valueOf(ischeckOut)));
//                                                        orderEntity.setPreStartCleanDate(clearStart);
//                                                        orderEntity.setPreEndCleanDate(clearEnd);
//
//
//                                                        QueryWrapper<OrderRecordEntity> orderRecordEntityQueryWrapper = new QueryWrapper<>();
//                                                        orderRecordEntityQueryWrapper.eq("order_id", orderEntity.getOrderId());
//                                                        orderRecordEntity = orderRecordService.getOne(orderRecordEntityQueryWrapper);
//                                                        orderRecordEntity.setComments(comments);
//                                                        baseMapper.updateById(orderEntity);
//                                                        orderRecordDao.updateById(orderRecordEntity);

                                                        }

                                                    }
                                                }
                                                return R.appOK();
                                            }
                                        } else {
                                            return R.error(0, "预打扫日期不正确");
                                        }
                                    } else {
                                        return R.error(0, "退房信息不能为空");
                                    }
                                } else {
                                    return R.error(0, "保洁类型不能为空");
                                }
                            } else {
                                return R.error(0, "保洁结束时间不能为空");
                            }
                        } else {
                            return R.error(0, "保洁开始时间不能为空");
                        }
                    } else {
                        return R.error(0, "房间号不能为空");
                    }
                } else {
                    return R.error(0, "民宿地址不能为空");
                }
            } else {
                return R.error(0, "民宿名称不能为空");
            }
        } else {
            return R.error(0, "民宿id不能为空");
        }
    }


}