package com.ideafix.model.security;

public class JwtAuthenticationRequest {
    final private String username;
    final private String password;

    public JwtAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
