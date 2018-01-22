package com.ideafix.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ideafix.model.pojo.AbstractUser;
import com.ideafix.model.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUser implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;

    public JwtUser(Long id, String username, String email,
                   String password,
                   Collection<? extends GrantedAuthority> authorities,
                   boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    public JwtUser(User user) {
        this.id = user.getId();
        this.username = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.authorities = (AuthorityUtils.
                commaSeparatedStringToAuthorityList(
                        user.getRole().getName()));
        this.enabled = !user.isBanned();
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}