package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 保洁阿姨的提成
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("staff_commission")
public class StaffCommissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 人员id
	 */
	private String staffId;
	/**
	 * 房间类型，关联dict_room_type表
	 */
	private Integer roomType;
	/**
	 * 房间提成，房间成为一室、两室、三室等标准提成，如果在标准以外。另外加床另外加几元
	 */
	private String commission;
	/**
	 * 备注
	 */
	private String comments;

}
