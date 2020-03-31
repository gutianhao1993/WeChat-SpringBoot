package com.yaao.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * @author GuTianHao
 * 清除失效告警定时器配置类
 */
public class ExpireMsgQuartzConfig {
    @Bean
    public JobDetail expireMsgTaskDetail() {
        return JobBuilder.newJob(ExpireMessageQuartz.class).withIdentity("ExpireMessageQuartz").storeDurably().build();
    }

    @Bean
    public Trigger expireMsgTaskTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withRepeatCount(1);
        return TriggerBuilder.newTrigger().forJob(expireMsgTaskDetail())
                .startAt(DateBuilder.futureDate(500, DateBuilder.IntervalUnit.MILLISECOND))
                .withIdentity("ExpireMessageQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
