package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单保洁信息表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("order_record")
public class OrderRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 关联订单记录表order_id
	 */
	private String orderId;
	/**
	 * 保洁阿姨选择
	 */
	private String staffId;
	/**
	 * 实际保洁时间
	 */
	private Date actualCleanDate;
	/**
	 * 是否优先，0是，1否
	 */
	private Integer isFirst;
	/**
	 * 保洁阿姨费用
	 */
	private BigDecimal staffCost;
	/**
	 * 保洁老板费用
	 */
	private BigDecimal bossCost;
	/**
	 * 保洁单状态,关联dict_order_status表
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String comments;

}
