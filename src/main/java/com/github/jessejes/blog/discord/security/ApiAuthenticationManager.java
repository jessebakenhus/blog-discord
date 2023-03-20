package com.github.jessejes.blog.discord.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


public class ApiAuthenticationManager implements AuthenticationManager {

    private final String apiValue;

    public ApiAuthenticationManager(String apiValue) {
        this.apiValue = apiValue;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (!apiValue.equalsIgnoreCase(authentication.getPrincipal().toString())) {
            throw new BadCredentialsException("Invalid api key or secrates");
        } else {
            authentication.setAuthenticated(true);
            return authentication;
        }
    }

}
