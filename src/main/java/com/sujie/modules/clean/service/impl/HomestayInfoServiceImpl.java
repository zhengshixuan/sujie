package com.sujie.modules.clean.service.impl;

import com.sujie.common.utils.MD5Utils;
import com.sujie.common.utils.R;
import com.sujie.modules.clean.dao.HomestayChargeRecordDao;
import com.sujie.modules.clean.entity.HomestayChargeRecordEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.Query;

import com.sujie.modules.clean.dao.HomestayInfoDao;
import com.sujie.modules.clean.entity.HomestayInfoEntity;
import com.sujie.modules.clean.service.HomestayInfoService;
import org.springframework.transaction.annotation.Transactional;


@Service("homestayInfoService")
@Transactional
public class HomestayInfoServiceImpl extends ServiceImpl<HomestayInfoDao, HomestayInfoEntity> implements HomestayInfoService {
    @Autowired
    private HomestayChargeRecordDao homestayChargeRecordDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<HomestayInfoEntity> queryWrapper = new QueryWrapper<HomestayInfoEntity>();
        if (StringUtils.isNotBlank((String) params.get("homestayName"))) {
            queryWrapper.like("homestay_name", params.get("homestayName"));
        }
        if (StringUtils.isNotBlank((String) params.get("operatorsName"))) {
            queryWrapper.like("operators_name", params.get("operatorsName"));
        }


        IPage<HomestayInfoEntity> page = this.page(
                new Query<HomestayInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<String> getAllWorkPalce() {
        List<String> allWorkPlace = baseMapper.getAllWorkPlace();
        return allWorkPlace;
    }

    @Override
    public Map<String, Object> getHomestayInfoDetail(Map<String, Object> params) {
        Map<String, Object> homestayInfoDetail = baseMapper.getHomestayInfoDetail(params);
        return homestayInfoDetail;
    }

    @Override
    public R recharge(HomestayInfoEntity homestayInfo) {
        HomestayInfoEntity oldHomestayInfo = baseMapper.selectById(homestayInfo.getId());
        if (null != oldHomestayInfo) {
            BigDecimal balance = oldHomestayInfo.getBalance();
            balance = homestayInfo.getBalance().add(balance);
            homestayInfo.setBalance(balance);

            HomestayChargeRecordEntity homestayChargeRecordEntity = new HomestayChargeRecordEntity();
            homestayChargeRecordEntity.setAmount(homestayInfo.getBalance());
            homestayChargeRecordEntity.setChargeDate(new Date());
            homestayChargeRecordEntity.setHomestayId(oldHomestayInfo.getHomestayId());
            baseMapper.updateById(homestayInfo);
            homestayChargeRecordDao.insert(homestayChargeRecordEntity);
        } else {
            return R.error("充值失败,请联系系统管理员");
        }
        return R.ok();
    }

    @Override
    public R updateHomestayInfo(HomestayInfoEntity homestayInfo) {

        HomestayInfoEntity oldHomestayInfo = baseMapper.selectById(homestayInfo.getId());
        if (null == oldHomestayInfo) {
            return R.error("未找到对应的民宿信息,请联系系统管理员");
        } else {
            if (!homestayInfo.getPassword().equalsIgnoreCase(oldHomestayInfo.getPassword())) {
                homestayInfo.setPassword(MD5Utils.getMD5(homestayInfo.getPassword()));
            }
            baseMapper.updateById(homestayInfo);
        }
        return R.ok();
    }

}