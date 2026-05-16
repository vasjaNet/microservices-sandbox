package org.s3m.chatservice.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public void sendMessage(ChatMessage chatMessage) {
        Message<ChatMessage> msg = MessageBuilder
                .withPayload(chatMessage)
                .setHeader(KafkaHeaders.TOPIC, "chat")
                .build();
        kafkaTemplate.send(msg);
    }
}
