
package com.sujie.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sujie.common.utils.PageUtils;
import com.sujie.modules.sys.entity.SysConfigEntity;

import java.util.Map;

/**
 * 系统配置信息
 */
public interface SysConfigService extends IService<SysConfigEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
	/**
	 * 保存配置信息
	 */
	void saveConfig(SysConfigEntity config);
	
	/**
	 * 更新配置信息
	 */
	void update(SysConfigEntity config);
	
	/**
	 * 根据key，更新value
	 */
	void updateValueByKey(String key, String value);
	
	/**
	 * 删除配置信息
	 */
	void deleteBatch(Long[] ids);
	
	/**
	 * 根据key，获取配置的value值
	 *
	 * @param key           key
	 */
	String getValue(String key);


}
