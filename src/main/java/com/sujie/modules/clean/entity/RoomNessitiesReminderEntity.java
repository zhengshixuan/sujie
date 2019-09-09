package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 一次性物品不足提醒表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:18
 */
@Data
@TableName("homestay.room_nessities_reminder")
public class RoomNessitiesReminderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 民宿id
	 */
	private String homestayId;
	/**
	 * 房间id
	 */
	private String roomId;
	/**
	 * 订单id
	 */
	private String orderId;
	/**
	 * 不足物品代码，关联dict_daily_nessities表
	 */
	private Integer nessistiesId;
	/**
	 * 0已补充，1未补充
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String comments;

}
