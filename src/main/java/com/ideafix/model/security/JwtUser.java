package com.ideafix.model.security;

import java.io.Serializable;

public class JwtUser implements Serializable {
    private String userName;
    private String password;

    public JwtUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
