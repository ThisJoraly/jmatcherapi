package ru.joraly.jmatcherapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String location;
    private String bio;
    private String photo;
}