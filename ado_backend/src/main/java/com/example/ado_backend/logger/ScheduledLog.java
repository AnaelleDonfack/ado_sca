package com.example.ado_backend.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class ScheduledLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledLog.class);

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime(){
        LOGGER.info("The current time now is {}", LocalDateTime.now());
    }
}
