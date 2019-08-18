package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 保洁阿姨信息
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("staff_info")
public class StaffInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 保洁人员id
	 */
	private String staffId;
	/**
	 * 保洁阿姨姓名
	 */
	private String staffName;
	/**
	 * 阿姨类别，0全职阿姨，1简直阿姨
	 */
	private Integer staffType;
	/**
	 * 联系电话
	 */
	private String telphone;
	/**
	 * 身份证号码
	 */
	private String idNo;
	/**
	 * 入职时间
	 */
	private Date entryTime;
	/**
	 * 照片
	 */
	private String photo;
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
