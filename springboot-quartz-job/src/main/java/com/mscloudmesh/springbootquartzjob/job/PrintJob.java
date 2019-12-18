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
 */
@DisallowConcurrentExecution
public class PrintJob implements Job, Serializable {

    private static Logger logger = LoggerFactory.getLogger(PrintJob.class);

    @Autowired
    private Scheduler scheduler;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(3000);
            logger.info("================执行打印任务完成========================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
