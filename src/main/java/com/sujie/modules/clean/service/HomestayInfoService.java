package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.entity.HomestayInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 民宿基本信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
public interface HomestayInfoService extends IService<HomestayInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询所有的工作地址
     * @return
     */
    List<String> getAllWorkPalce();

    Map<String,Object> getHomestayInfoDetail(Map<String,Object> params);


    /**
     * 充值金额
     * @param homestayInfo
     * @return
     */
    R recharge(HomestayInfoEntity homestayInfo);


    /**
     * 更新民宿信息
     * @param homestayInfo
     * @return
     */
    R updateHomestayInfo(HomestayInfoEntity homestayInfo);
}

