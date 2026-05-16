package org.s3m.chatservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaTopicConfig {

    @Bean
    public NewTopic chatTopic() {
        return TopicBuilder
                .name("chat")
                .build();
    }
}
