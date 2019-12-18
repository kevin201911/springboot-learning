package com.mscloudmesh.springbootkafkabatch.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    @Autowired
    private KafkaTemplate<String,byte[]> kafkaTemplate;
    private final String topic = "topic1";
 
    public void sendMessage(int key,String value){
        ProducerRecord<String,byte[]> record = new ProducerRecord<>(topic,
                key%3,String.valueOf(key),value.getBytes());
        kafkaTemplate.send(record);
    }
}