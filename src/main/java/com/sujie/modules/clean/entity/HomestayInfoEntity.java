package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 民宿基本信息表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-17 09:35:24
 */
@Data
@TableName("homestay.homestay_info")
public class HomestayInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Integer id;
    /**
     * 民宿id
     */
    private String homestayId;
    /**
     * 名宿名称
     */
    private String homestayName;
    /**
     * 老板姓名
     */
    private String bossName;
    /**
     * 老板电话号码
     */
    private String bossTelephone;
    /**
     * 运营者姓名
     */
    private String operatorsName;
    /**
     * 运营者电话
     */
    private String operatorsTelephone;
    /**
     * 详细地址
     */
    private String homestayAddress;
    /**
     * 民宿房间数量
     */
    private Integer roomsNumber;
    /**
     * 是否有前台，0否，1是
     */
    private Integer isReception;
    /**
     * 客户类型（办卡会员）0否，1是
     */
    private Integer isVip;
    /**
     * 账户余额，默认为0
     */
    private BigDecimal balance;
    /**
     * 运营者登录密码
     */
    private String password;

    /**
     * 前台房间号
     */
    private String receptionPassword;

    /**
     * 公司电话
     */
    private String workPhone;
    /**
     * 客服微信
     */
    private String customerWx;
    /**
     * 客服电话
     */
    private String customerPhone;

    /**
     * 工作时间
     */
    private String workTime;

    /**
     * 民宿logo
     */
    private String logo;


}
