package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单状态字典表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("homestay.dict_order_status")
public class DictOrderStatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单状态代码
	 */
	private Integer itemCode;
	/**
	 * 订单状态名称
	 */
	private String itemName;
	/**
	 * 排序
	 */
	private Integer seqNo;
	/**
	 * 备注
	 */
	private String comments;

}
