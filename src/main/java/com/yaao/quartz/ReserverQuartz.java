package com.yaao.quartz;

import com.yaao.service.SendMessageService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * 定时检测有无Flag=2的告警,重发告警
 *
 * @author GuTianHao
 */
@Configuration
public class ReserverQuartz extends QuartzJobBean {
    @Resource
    private SendMessageService sendMessageService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       sendMessageService.resendTemplateMsg();
    }
}
