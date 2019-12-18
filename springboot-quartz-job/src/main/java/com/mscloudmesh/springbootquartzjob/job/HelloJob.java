package com.mscloudmesh.springbootquartzjob.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kevin
 * @date 2019/12/18
 *   不必担心线程安全性，因为同一时刻仅有一个线程去执行给定 Job 类的实例，甚至是并发执行同一 Job 也是如此。
 * @desc  保证上一个任务执行完后，再去执行下一个任务
 */
@DisallowConcurrentExecution
public class HelloJob implements Job, Serializable {
  
    private static Logger logger = LoggerFactory.getLogger(HelloJob.class);

    @Autowired
    private Scheduler scheduler;
     
    public void execute(JobExecutionContext context) throws JobExecutionException{
        try {
        logger.info("Hello Job执行时间: " + new Date()+"  Blog:"+context.getJobDetail().getJobDataMap().get("blog"));
        Thread.sleep(1000 * 5);
        System.out.println("================执行完成========================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}  
