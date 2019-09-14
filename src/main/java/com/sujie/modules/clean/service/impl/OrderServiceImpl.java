package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.sujie.modules.clean.dao.OrderRecordDao;
import com.sujie.modules.clean.service.OrderRecordService;
import com.sujie.modules.clean.service.StaffInfoService;
import com.sujie.modules.clean.vo.OrderVO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Override
    public List<Map<String, Object>> getOrdersByHomestayIdAndRoomId(Map<String, Object> params) {



        List<Map<String, Object>> list = baseMapper.getOrdersByHomestayIdAndRoomId(params);
        return list;
    }

    @Override
    public boolean updateOrder(Map<String, Object> params) {
        params.put("status", 3);
        params.put("cleanStatusCode", 3);
        orderRecordService.updateRecordStatus(params);
        baseMapper.updateCleanStatusCode(params);
        return true;
    }

    @Override
    public Map<String, Object> getTodayPreOrder(Map<String, Object> params) {
        Map<String, Object> map = staffInfoService.listStaffInfoByTelphone(params);
        if (StringUtils.isNotBlank((String) map.get("address"))) {
            params.put("address", map.get("address"));
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
}