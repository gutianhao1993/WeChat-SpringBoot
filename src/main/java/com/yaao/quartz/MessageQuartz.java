package com.yaao.quartz;

import com.yaao.service.SendMessageService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 定时检测有无flag=0的告警,若有则发送
 *
 * @author GuTianHao
 */

@DisallowConcurrentExecution
public class MessageQuartz extends QuartzJobBean {
    @Resource
    private SendMessageService sendMessageService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        sendMessageService.sendTemplateMsg();
    }
}
