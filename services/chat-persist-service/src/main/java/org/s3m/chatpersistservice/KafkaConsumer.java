package org.s3m.chatpersistservice;

import lombok.extern.slf4j.Slf4j;
import org.s3m.chatservice.chat.ChatMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "chat", groupId = "chat-persist-service-group")
    public void consume(ChatMessage chatMessage) {
        log.info("Consuming messages" + chatMessage);
    }
}
