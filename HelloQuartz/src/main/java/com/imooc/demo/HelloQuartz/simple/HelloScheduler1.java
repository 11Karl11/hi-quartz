package com.imooc.demo.HelloQuartz.simple;

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

    public static void main(String[] args) throws SchedulerException {

        // 打印当前的时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is  HelloScheduler1 : " + sf.format(date));
        // 创建一个JobDetail实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                // .usingJobData("mathJobValue",3.14F)
                // .usingJobData("message","hello myJob1")
                .build();
        // //获取距离当前时间3秒后的时间
        // date.setTime(date.getTime()+3000);
        // //获取距离当前时间6秒后的时间
        // Date end = new Date();
        // end.setTime(end.getTime()+6000);

        // //创建一个trigger实例,定义job立即执行,并且每隔两秒重复一次,直到永远
        // SimpleTrigger trigger = TriggerBuilder
        //         .newTrigger()
        //         .withIdentity("myTrigger", "group1")
        //         // .usingJobData("message","hello myTrigger1")
        //         // .usingJobData("DoubleTriggerValue",2.0D)
        //         // .startNow()
        //         // .startAt(date)
        //         // .endAt(end)
        //         .withSchedule(SimpleScheduleBuilder.simpleSchedule()
        //                 .withIntervalInSeconds(2).repeatForever()).build();

        //距离当前时间四秒后执行且执行一次任务
        /**
         *  获取距离当前时间四秒之后的具体时间
        */
        date.setTime(date.getTime()+4000);
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                // .usingJobData("message","hello myTrigger1")
                // .usingJobData("DoubleTriggerValue",2.0D)
                // .startNow()
                .startAt(date)
                // .endAt(end)
                .build();
        //创建scheduler实例
        StdSchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);



    }

}