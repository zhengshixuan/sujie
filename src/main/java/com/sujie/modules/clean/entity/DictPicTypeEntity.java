package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 图片类别字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-09-01 13:55:56
 */
@Data
@TableName("homestay.dict_pic_type")
public class DictPicTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 图片类别代码
	 */
	private Integer itemCode;
	/**
	 * 图片类别名称
	 */
	private String itemName;
	/**
	 * 序号
	 */
	private Integer seqNo;
	/**
	 * 描述
	 */
	private String comments;

}
