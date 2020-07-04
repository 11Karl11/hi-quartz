package com.karl.springboot.quartz.quartz;

import com.karl.springboot.quartz.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-07-04 15:31
 */
public class QuartzDemo implements Job {

    @Autowired
    private UserService userService;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("execute----"+new Date());
        userService.addUser();
    }
}