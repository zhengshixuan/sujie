package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 保洁订单主表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取预排单总数
     */
  List<Map<String,Object>> listPreOrder(Map<String,Object> map);

    /**
     * 查询待保洁的总数据
     * @param map
     * @return
     */
  Integer getPreorderCount(Map<String,Object> map);

    /**
     * 获取详细预排单
     * @param map
     * @return
     */
    List<Map<String,Object>> listPreOrderDetail(Map<String,Object> map);


}

