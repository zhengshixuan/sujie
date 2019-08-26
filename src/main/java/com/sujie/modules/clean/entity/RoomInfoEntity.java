package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 房间信息
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:20
 */
@Data
@TableName("homestay.room_info")
public class RoomInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 民宿id(关联homestay_info表homestay_id)
	 */
	private String homestayId;
	/**
	 * 房间编号,多少楼多少编号
	 */
	private String roomId;
	/**
	 * 房间地址
	 */
	private String roomAddress;
	/**
	 * 开门方式：0密码锁：输入密码加#进入，1钥匙盒子
	 */
	private Integer openMethod;
	/**
	 * 保洁密码(主要是针对保洁密码长期不变的客户)
	 */
	private String roomPassword;
	/**
	 * 房间户型(一室、二室、三室等)
	 */
	private Integer roomType;
	/**
	 * 房间内摆设分几个区域：床上，沙发区域，厨房区域，卫生间区域
	 */
	private String roomDecoration;
	/**
	 * 房间内特殊信息显示(关联特殊信息详细表room_clain_info)
	 */
	private String roomClainId;
	/**
	 * 是否需要洗床单0需要，1不需要
	 */
	private Integer needWashingSheets;
	/**
	 * 收费价格
	 */
	private BigDecimal price;
	/**
	 * 备注：找到房间的说明(一个房门里面两个房间或多个的情况)
	 */
	private String comments;

}
