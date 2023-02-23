package com.example.exchange;

import com.example.exchange.tasks.ApiRequestScheduler;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class ExchangeApplication {


    public static void main(String[] args) throws SchedulerException {
        SpringApplication.run(ExchangeApplication.class, args);
        onStart();
    }

    public static void onStart() throws SchedulerException {
        log.info("Scheduler started");
        ApiRequestScheduler apiRequestScheduler = new ApiRequestScheduler();
        apiRequestScheduler.scheduleApiRequest();
    }

}
