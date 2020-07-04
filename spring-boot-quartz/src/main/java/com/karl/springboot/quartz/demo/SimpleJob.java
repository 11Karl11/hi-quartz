package com.karl.springboot.quartz.demo;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @author karl xie
 * Created on 2020-07-04 15:08
 */
// @Configuration
// @EnableScheduling
public class SimpleJob {

    @Scheduled(cron = "* * * * * *")
    public void run(){
        System.out.println(LocalDateTime.now());
    }
}