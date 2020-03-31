package com.yaao.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * @author GuTianHao
 * 重发定时器配置类
 */
public class ReserverQuartzConfig {
    @Bean
    public JobDetail reserverTaskDetail() {
        return JobBuilder.newJob(ReserverQuartz.class).withIdentity("ReserverQuartz").storeDurably().build();
    }

    @Bean
    public Trigger reserverTaskTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(20)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(reserverTaskDetail())
                .startAt(DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND))
                .withIdentity("ReserverQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
