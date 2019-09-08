package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.OrderRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单保洁信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface OrderRecordService extends IService<OrderRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    int updateRecordStatus(Map<String,Object> params);


}

