package com.mscloudmesh.springbootkafkabatch.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BatchListener {
    private final String topic = "topic1";
 
 
    @KafkaListener(id="myListener",
            topicPartitions ={@TopicPartition(topic = topic, partitions = { "0", "1" ,"2"})})
    public void listen(List<ConsumerRecord<String, byte[]>> recordList) {
        recordList.forEach((record)->{
            log.info("kafka的key: " + record.key());
            log.info("kafka的value: " + new String(record.value()));
        });
    }
}