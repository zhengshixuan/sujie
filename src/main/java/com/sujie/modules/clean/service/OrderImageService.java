package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.OrderImageEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单图片信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface OrderImageService extends IService<OrderImageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过订单id查询订单相关图片
     * @param params
     * @return
     */
    List<Map<String,Object>> findOrderImageByOrderId(Map<String, Object> params);
}

