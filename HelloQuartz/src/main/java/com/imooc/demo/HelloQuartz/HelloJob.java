package com.imooc.demo.HelloQuartz;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author karl xie
 * Created on 2020-07-02 18:36
 */
public class HelloJob implements Job {

    //quartz会自动赋值
    private String message;
    private String DoubleTriggerValue;
    private String mathJobValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDoubleTriggerValue() {
        return DoubleTriggerValue;
    }

    public void setDoubleTriggerValue(String doubleTriggerValue) {
        DoubleTriggerValue = doubleTriggerValue;
    }

    public String getMathJobValue() {
        return mathJobValue;
    }

    public void setMathJobValue(String mathJobValue) {
        this.mathJobValue = mathJobValue;
    }

    public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// try {
		// 	Thread.sleep(5000L);
		// } catch (InterruptedException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
		// 打印当前的执行时间，格式为2017-01-01 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec Time Is : " + sf.format(date));
        System.out.println("hello world");
        // Trigger trigger = context.getTrigger();
        // System.out.println("start time:"+trigger.getStartTime());
        // System.out.println("end time:"+trigger.getEndTime());
        // JobKey jobKey = trigger.getJobKey();
        // System.out.println("job name"+jobKey.getName()+"job group "+jobKey.getGroup());
        // // System.out.println("Hello World");
		// JobKey key = context.getJobDetail().getKey();
		// System.out.println("job"+key.getName()+"----"+key.getGroup());
        // TriggerKey triggerKey = context.getTrigger().getKey();
        // System.out.println("trigger"+triggerKey.getName()+"----"+triggerKey.getGroup());
        //
        // // JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        // // JobDataMap tjobDataMap = context.getTrigger().getJobDataMap();
        //
        //
        // //合并后的map,trigger的key如果和job的key一样的话会覆盖掉job的key
        // // JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        // // Float mathJobValue = mergedJobDataMap.getFloatValue("mathJobValue");
        // // String message = mergedJobDataMap.getString("message");
        // // Double doubleTriggerValue = mergedJobDataMap.getDouble("DoubleTriggerValue");
        // // String tmessage = mergedJobDataMap.getString("message");
        // System.out.println("job value  mathJobValue"+mathJobValue+"message"+message);
        // System.out.println("trigger value  doubleTriggerValue"+DoubleTriggerValue+"tmessage"+message);

    }


}