package com.ideafix.service.impl;

import com.ideafix.model.security.JwtUser;
import com.ideafix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public JwtUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return new JwtUser(userService.getUserByNickname(username));
    }
}
