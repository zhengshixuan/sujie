package com.sujie.modules.clean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@TableName("homestay.ad_image")
public class AdImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 图片状态,0为下线,1为上线,默认查询状态为1上线中的数据
	 */
	private Integer status;
	/**
	 * 图片地址
	 */
	private String path;
	/**
	 * 描述
	 */
	private String comments;

}
