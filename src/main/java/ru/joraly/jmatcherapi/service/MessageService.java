package ru.joraly.jmatcherapi.service;

import ru.joraly.jmatcherapi.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> getAllMessages();
    Optional<Message> getMessageById(Long id);
    Message createMessage(Message user);
    Message updateMessage(Message message);
    void deleteMessage(Long id);
}
