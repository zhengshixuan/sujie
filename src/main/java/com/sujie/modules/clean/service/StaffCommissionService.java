package com.sujie.modules.clean.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.entity.StaffCommissionEntity;

import java.util.Map;

/**
 * 保洁阿姨的提成
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:15
 */
public interface StaffCommissionService extends IService<StaffCommissionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过人员id和房间类型查询提成信息
     * @param params
     * @return
     */
    StaffCommissionEntity getStaffCommissionByStaffIdAndRoomType(Map<String, Object> params);


}

