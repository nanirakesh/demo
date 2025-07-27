//package com.example.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//@Configuration
//@EnableScheduling
//public class SchedulerConfig implements SchedulingConfigurer {
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar registrar) {
//        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//        scheduler.setPoolSize(4); // Set pool size >= number of scheduled tasks
//        scheduler.setThreadNamePrefix("scheduler-");
//        scheduler.initialize();
//        registrar.setTaskScheduler(scheduler);
//    }
//}
