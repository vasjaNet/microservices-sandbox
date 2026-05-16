package org.s3m.chatservice.chat;

import lombok.*;
import org.s3m.chatpersistservice.MessageType;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;
}
