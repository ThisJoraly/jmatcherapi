package ru.joraly.jmatcherapi.model.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String message;
}