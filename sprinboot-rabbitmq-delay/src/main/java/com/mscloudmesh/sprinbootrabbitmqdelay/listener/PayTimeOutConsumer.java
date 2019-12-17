package com.mscloudmesh.sprinbootrabbitmqdelay.listener;

import java.io.IOException;

import com.mscloudmesh.sprinbootrabbitmqdelay.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;



/**
 * @title 消息消费端
 * @author kevin
 * @Date 2019/12/14
 * @Description 
 */
@Component
public class PayTimeOutConsumer {
    
   // @Autowired
   // TradeService tradeService;
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @RabbitListener(queues = RabbitConfig.Timeout_Trade_Queue_Name)
    public void process(String tradeCode, Message message, Channel channel) throws IOException{
        try {
            logger.info("开始执行订单[{}]的支付超时订单关闭......", tradeCode);
            logger.info("开始取消订单业务");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            logger.info("超时订单处理完毕");
        } catch (Exception e) {
            logger.error("超时订单处理失败:{}", "失败");
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        } 
    }

}