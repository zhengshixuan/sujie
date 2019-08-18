package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 日用品字典表
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:19
 */
@Data
@TableName("dict_daily_nessities")
public class DictDailyNessitiesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 日用品代码
	 */
	private Integer itemCode;
	/**
	 * 日用品名称
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
