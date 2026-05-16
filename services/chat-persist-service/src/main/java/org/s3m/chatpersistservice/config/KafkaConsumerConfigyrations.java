package org.s3m.chatpersistservice.config;

import lombok.RequiredArgsConstructor;
import org.s3m.chatservice.chat.ChatMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfigyrations {

    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ChatMessage> kafkaListenerContainerFactory(
            ConsumerFactory<String, ChatMessage> consumerFactory) {

        var factory = new ConcurrentKafkaListenerContainerFactory<String, ChatMessage>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(new DefaultErrorHandler(
                new DeadLetterPublishingRecoverer(kafkaTemplate),
                new FixedBackOff(1000L, 3)  // retry 3 times, 1s apart
        ));
        return factory;
    }
}
