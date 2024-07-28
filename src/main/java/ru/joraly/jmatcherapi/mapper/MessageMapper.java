package ru.joraly.jmatcherapi.mapper;


import org.mapstruct.Mapper;
import ru.joraly.jmatcherapi.model.Message;
import ru.joraly.jmatcherapi.model.User;
import ru.joraly.jmatcherapi.model.dto.request.MessageRequest;
import ru.joraly.jmatcherapi.model.dto.request.UserRequest;
import ru.joraly.jmatcherapi.model.dto.response.MessageResponse;
import ru.joraly.jmatcherapi.model.dto.response.UserResponse;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message requestToObject(MessageRequest messageRequest);
    MessageResponse objectToResponse(Message message);
}