package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 房间图片信息表
 * 
 * @date 2019-09-01 13:55:56
 */
@Data
@TableName("homestay.room_image")
public class RoomImageEntity implements Serializable {
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
	 * 房间id
	 */
	private String roomId;
	/**
	 * 图片类别(关联dict_pic_type表item_code)
	 */
	private Integer picTypeCode;
	/**
	 * 图片地址
	 */
	private String picPath;
	/**
	 * 描述
	 */
	private String comments;

}
