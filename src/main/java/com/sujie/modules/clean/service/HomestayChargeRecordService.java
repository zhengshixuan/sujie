package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.HomestayChargeRecordEntity;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 充值记录表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-09-21 10:09:37
 */
public interface HomestayChargeRecordService extends IService<HomestayChargeRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询历史充值总额
     * @param params
     * @return
     */
    BigDecimal getChargeCount(Map<String,Object> params);
}

