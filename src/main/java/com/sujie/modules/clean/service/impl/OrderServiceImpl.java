package com.sujie.modules.clean.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mysql.fabric.xmlrpc.base.Params;
import com.sujie.modules.clean.vo.OrderVO;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public PageUtils listRoomCleanRecord(Map<String, Object> params) {
        IPage<OrderVO> page = new Query<OrderVO>().getPage(params);
        IPage<OrderVO> orderVOIPage = baseMapper.listRoomCleanRecord(page, params);
        return new PageUtils(orderVOIPage);
    }

    @Override
    public PageUtils listPrepareCleanOrder(Map<String, Object> params) {
        return null;
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