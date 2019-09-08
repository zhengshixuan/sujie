package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单图片信息表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("homestay.order_image")
public class OrderImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单id，关联order表order_id
	 */
	private String orderId;
	/**
	 * 图片类型id,关联dict_pic_type的item_code
	 */
	private Integer picTypeCode;
	/**
	 * 照片
	 */
	private String path;

}
