package com.karl.springboot.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author karl xie
 * Created on 2020-07-04 15:58
 */
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

    //可以将对象添加到springIOC容器中并完成对象注入
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    //该方法要将实例化的对象手动的添加到springIOC容器中并完成注入
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        //将obj对象添加到springIOC容器中
        this.autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }
}