package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 保洁订单主表
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("homestay.order")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 民宿id
     */
    private String homestayId;
    /**
     * 房间id
     */
    private String roomId;
    /**
     * 保洁类型关联dict_clean_type
     */
    private Integer cleanType;
    /**
     * 预开始打扫时间
     */
    private Date preStartCleanDate;
    /**
     * 预结束打扫时间
     */
    private Date preEndCleanDate;
    /**
     * 保洁费用
     */
    private BigDecimal cleanPrice;
    /**
     * 是否已经退房，0是，1否
     */
    private Integer isCheckOut;
    /**
     * 退房时间
     */
    private Date checkOutDate;
    /**
     * 关联dict_clean_status
     */
    private Integer cleanStatusCode;
    /**
     * 生成时间
     */
    private Date createDate;

}
