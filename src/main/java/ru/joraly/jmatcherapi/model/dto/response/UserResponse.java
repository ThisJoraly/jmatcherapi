package ru.joraly.jmatcherapi.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String location;
    private String bio;
    private String photo;
}