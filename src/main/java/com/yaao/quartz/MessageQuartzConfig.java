package com.yaao.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuTianHao
 * 发送信息定时器配置类
 */
@Configuration
public class MessageQuartzConfig {
    @Bean
    public JobDetail messageTaskDetail() {
        return JobBuilder.newJob(MessageQuartz.class).withIdentity("MessageQuartz").storeDurably().build();
    }

    @Bean
    public Trigger messageTaskTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(messageTaskDetail())
                .startAt(DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND))
                .withIdentity("MessageQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
