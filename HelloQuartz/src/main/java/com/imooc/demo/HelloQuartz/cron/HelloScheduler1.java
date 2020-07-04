package com.imooc.demo.HelloQuartz.cron;

import com.imooc.demo.HelloQuartz.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-07-02 18:43
 */
public class HelloScheduler1 {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        // 打印当前的时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is  HelloScheduler1 : " + sf.format(date));
        // 创建一个JobDetail实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        //距离当前时间四秒后执行且执行一次任务,之后每隔两秒钟重复执行一次,直到距离当前时间6秒钟之后

        CronTrigger trigger = (CronTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();
        //创建scheduler实例
        StdSchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        //返回最近执行的时间
        Date time = scheduler.scheduleJob(jobDetail, trigger);

        System.out.println("scheduler time "+ time);


        //scheduler执行两秒后挂起
        Thread.sleep(2000);
        // scheduler.standby();

        scheduler.shutdown(true);
        //scheduler挂起三秒后继续执行

        Thread.sleep(3000);
        scheduler.start();


    }

}