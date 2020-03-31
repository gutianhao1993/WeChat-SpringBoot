package com.yaao.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuTianHao
 * 缓存定时器配置类
 */
@Configuration
public class CachedQuartzConfig {
    @Bean
    public JobDetail cachedTaskDetail() {
        return JobBuilder.newJob(CachedQuartz.class).withIdentity("CachedQuartz").storeDurably().build();
    }

    @Bean
    public Trigger cachedTaskTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(3600)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(cachedTaskDetail())
                .withIdentity("CachedQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
