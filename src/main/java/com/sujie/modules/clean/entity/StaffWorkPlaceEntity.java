package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 保洁阿姨工作位置
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("staff_work_place")
public class StaffWorkPlaceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 关联staff_info中staff_id
	 */
	private String staffId;
	/**
	 * 省代码
	 */
	private String provinceCode;
	/**
	 * 省名称
	 */
	private String provinceName;
	/**
	 * 市代码
	 */
	private String cityCode;
	/**
	 * 市名称
	 */
	private String cityName;
	/**
	 * 区代码
	 */
	private String countyCode;
	/**
	 * 区名称
	 */
	private String countyName;
	/**
	 * 详细地址
	 */
	private String address;

}
