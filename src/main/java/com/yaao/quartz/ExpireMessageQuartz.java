package com.yaao.quartz;

import com.yaao.service.SendMessageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 每次启动程序时清除失效告警
 *
 * @author GuTianHao
 */
public class ExpireMessageQuartz extends QuartzJobBean {
    @Resource
    private SendMessageService sendMessageService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        sendMessageService.setExpireMsg();
    }
}
