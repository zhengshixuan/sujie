package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 房间类型字典表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("dict_room_type")
public class DictRoomTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 房间代码
	 */
	private Integer itemCode;
	/**
	 * 房间名称
	 */
	private String itemName;
	/**
	 * 序号
	 */
	private Integer seqNo;
	/**
	 * 标准价格
	 */
	private BigDecimal price;
	/**
	 * 备注
	 */
	private String comments;

}
