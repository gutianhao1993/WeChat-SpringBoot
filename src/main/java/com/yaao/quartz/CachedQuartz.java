package com.yaao.quartz;

import com.yaao.service.CachedService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 获取数据库缓存定时器
 *
 * @author GuTianHao
 */

@DisallowConcurrentExecution
public class CachedQuartz extends QuartzJobBean {
    @Resource
    private CachedService cachedService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        cachedService.beginCached();
    }
}
