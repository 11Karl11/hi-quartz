package com.karl.springboot.quartz.config;

import com.karl.springboot.quartz.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author karl xie
 * Created on 2020-07-04 15:32
 */
@Configuration
public class QuartzConfig {


    //创建job对象
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        //关联我们自己的job类
        factoryBean.setJobClass(QuartzDemo.class);
        return factoryBean;
    }


   /* //创建trigger对象(简单的trigger)
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        //关联JobDetail
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        //该参数表示一个执行的毫秒数
        factory.setRepeatInterval(2000);
        //设置重复次数
        factory.setRepeatCount(5);
        return factory;
    }*/


   //创建cron trigger
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        //设置触发时间
        factory.setCronExpression("0/2 * * * * ?");
        return factory;
    }


    //创建schedule对象
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(
            CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        //关联trigger
        factory.setTriggers(cronTriggerFactoryBean.getObject());
        factory.setJobFactory(myAdaptableJobFactory);
        return factory;
    }

}