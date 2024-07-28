package ru.joraly.jmatcherapi.mapper;


import org.mapstruct.Mapper;
import ru.joraly.jmatcherapi.model.User;
import ru.joraly.jmatcherapi.model.dto.request.UserRequest;
import ru.joraly.jmatcherapi.model.dto.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User requestToObject(UserRequest userRequest);
    UserResponse objectToResponse(User user);
}