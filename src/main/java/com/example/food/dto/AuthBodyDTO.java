package com.example.food.dto;

/**
 * Auth DTO.
 *
 * @author kaminskiy.alexey
 * @since 2019.12
 */

public class AuthBodyDTO {

    private String login;
    private String password;

    public AuthBodyDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
