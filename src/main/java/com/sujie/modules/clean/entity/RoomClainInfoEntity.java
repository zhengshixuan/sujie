package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 房间内特殊信息显示
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:20
 */
@Data
@TableName("room_clain_info")
public class RoomClainInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 房间内特殊信息显示(关联room_info中room_clain_id)
	 */
	private String roomClainId;
	/**
	 * 牙刷牙膏位置
	 */
	private String toothbruthAddr;
	/**
	 * 卫生纸，垃圾袋位置
	 */
	private String toiletPaperAddr;
	/**
	 * 床单，被套位置(总共有几套备用。)
	 */
	private String quiltAddr;
	/**
	 * 洗衣液，洗衣粉位置
	 */
	private String washingPowderAddr;
	/**
	 * 衣架位置
	 */
	private String hangerAddr;
	/**
	 * 厨具存放位置
	 */
	private String kitchenwareAddr;

}
