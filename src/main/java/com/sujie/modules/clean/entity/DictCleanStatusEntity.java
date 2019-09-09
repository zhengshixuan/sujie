package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 打扫状态字典
 * 
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:15:20
 */
@Data
@TableName("homestay.dict_clean_status")
public class DictCleanStatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 状态代码
	 */
	private Integer cleanStatusCode;
	/**
	 * 状态名称
	 */
	private String cleanStatusName;
	/**
	 * 排序
	 */
	private Integer seqNo;
	/**
	 * 备注
	 */
	private String comments;

}
