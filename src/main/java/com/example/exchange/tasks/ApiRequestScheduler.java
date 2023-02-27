package com.example.exchange.tasks;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Slf4j
@Component
public class ApiRequestScheduler {

    public void scheduleApiRequest() throws SchedulerException {
        //schedule the api request to run every 24 hours
//        log.info("Scheduling api request public class ApiRequestScheduler");
//        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//        JobDetail job = newJob(ApiRequestJob.class)
//                .withIdentity("apiRequestJob", "group1")
//                .build();
//
//        Trigger trigger = newTrigger()
//                .withIdentity("apiRequestTrigger", "group1")
//                .withSchedule(simpleSchedule()
//                        .withIntervalInHours(24)
//                        .repeatForever())
//                .build();
//        scheduler.start();
//        scheduler.scheduleJob(job, trigger);

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail job = newJob(ApiRequestJob.class)
                .withIdentity("apiRequestJob", "group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("apiRequestTrigger", "group1")
                .withSchedule(simpleSchedule()
                        .withIntervalInHours(24)
                        .repeatForever())
                .build();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);


    }

}
