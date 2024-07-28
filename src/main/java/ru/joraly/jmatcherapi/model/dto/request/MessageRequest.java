package ru.joraly.jmatcherapi.model.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    private Long senderId;
    private Long receiverId;
    private String message;
}