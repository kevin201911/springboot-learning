package com.mscloudmesh.springbootredisqueue.config;

import com.mscloudmesh.springbootredisqueue.constants.GlobalConstant;
import com.mscloudmesh.springbootredisqueue.receive.RedisMessageReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * @author kevin
 * @date 2019/12/10
 * @desc redis配置中心
 */
@Configuration
public class RedisConfig {


    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    /**
     * 消息消费者 适配器，其中 receivedMsg为定义的消费者的消费方法，必须保持一致
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisMessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receivedMsg");
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    /**
     * 消息监听容器，将适配器加入， 注意此处的 topic
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(GlobalConstant.MSG_TOPIC));

        return container;
    }
}