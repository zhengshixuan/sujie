package com.sujie.modules.clean.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderVO {
    private String id;

    /**
     * 是否优先打扫
     */
    private Integer isFirst;
    /**
     * 老板费用
     */
    private BigDecimal bossCost;
    /**
     * 预打扫时间
     */
    private Date preCleanDate;
    /**
     * 实际保洁时间
     */
    private Date actualCleanDate;

    /**
     * 民宿名称
     */
    private String homestayName;

    /**
     * 民宿地址
     */
    private String homestayAddress;

    /**
     * 房间号
     */
    private String roomId;
    /**
     * 户型
     */
    private String roomType;

    /**
     * 备注
     */
    private String comments;

    /**
     * 保洁费用
     */
    private BigDecimal staffCost;

    /**
     * 保洁阿姨
     */
    private String staffName;
    /**
     * 阿姨id
     */
    private String staffId;

    /**
     * 订单状态
     */
    private String statusName;


    /**
     * 下单时间
     */
    private String createDate;

}
