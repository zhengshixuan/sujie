package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 保洁类型字典
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:20
 */
@Data
@TableName("dict_clean_type")
public class DictCleanTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 清洁类型字典
	 */
	private Integer cleanTypeCode;
	/**
	 * 清洁类型名称
	 */
	private String cleanTypeName;
	/**
	 * 排序
	 */
	private Integer seqNo;
	/**
	 * 备注
	 */
	private String comments;

}
