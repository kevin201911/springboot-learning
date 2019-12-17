package com.mscloudmesh.springbootelasticjob.job;

import java.util.List;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.mscloudmesh.springbootelasticjob.domain.Mail;


public class MailSendJob implements DataflowJob<Mail> {

    @Override
    public List<Mail> fetchData(ShardingContext shardingContext) {
        System.out.println(shardingContext.getShardingItem() + "====" + shardingContext.getShardingTotalCount());
        return null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Mail> data) {
        System.out.println(data);
        // TODO Auto-generated method stub
    }

}
