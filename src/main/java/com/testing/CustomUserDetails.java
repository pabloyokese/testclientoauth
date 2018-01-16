package com.testing;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pabloyokese on 5/29/2017.
 */
public class CustomUserDetails implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1881653660625948861L;
	private String id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    public CustomUserDetails(User byUsername) {
        this.username = byUsername.getEmail();
        this.password = byUsername.getPassword();
        this.id = byUsername.getId();
        List<GrantedAuthority> auths = new ArrayList<>();
        for (Role role: byUsername.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }
        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    String getId() {
        return id;
    }
}
