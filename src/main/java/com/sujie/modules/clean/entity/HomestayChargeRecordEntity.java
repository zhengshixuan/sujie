package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 充值记录表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-09-21 10:09:37
 */
@Data
@TableName("homestay.homestay_charge_record")
public class HomestayChargeRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 民宿id
	 */
	private String homestayId;
	/**
	 * 充值金额
	 */
	private BigDecimal amount;
	/**
	 * 充值时间
	 */
	private Date chargeDate;

}
