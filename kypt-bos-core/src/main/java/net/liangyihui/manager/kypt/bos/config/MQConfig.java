package net.liangyihui.manager.kypt.bos.config;

import com.aliyun.mq.http.MQClient;
import com.aliyun.mq.http.MQConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MQConfig {

//    @Value("${mq.rocket.instanceId}")
//    private String mqInstanceId;
//
//    @Value("${mq.rocket.topicName}")
//    private String mqTopicName;
//
//    @Value("${mq.rocket.groupId}")
//    private String mqGroupId;
//
//    @Value("${mq.rocket.targetName}")
//    private String mqTargetName;
//
//    @Value("${mq.rocket.httpEndpoint}")
//    private String rocketMqEndpoint;
//
//    @Value("${mq.rocket.accessKey}")
//    private String accessKey;
//
//    @Value("${mq.rocket.secretKey}")
//    private String secretKey;
//
//    @Bean
//    public MQConsumer getConsumer() {
//        MQClient mqClient = new MQClient(rocketMqEndpoint, accessKey, secretKey);
//        return mqClient.getConsumer(mqInstanceId, mqTopicName, mqGroupId, mqTargetName);
//    }
}
