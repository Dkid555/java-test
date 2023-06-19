package com.app.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public User(String userName, String email, String role) {
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

    private String userName;
    private String email;
    private String role;

}
