package com.sujie.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sujie.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
