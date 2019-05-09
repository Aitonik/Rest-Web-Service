package ru.aitalina.rest_ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    Long id;

    String login;

    String password;

    String[] roles;

    UserDto(String login, String password, String[] roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }
}
