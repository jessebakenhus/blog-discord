package com.github.jessejes.blog.discord.configurations;

import com.github.jessejes.blog.discord.security.ApiAuthenticationManager;
import com.github.jessejes.blog.discord.security.ApiFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        Map<String, String> getenv = System.getenv();
        String value = getenv.get("API_TOKEN");

        ApiFilter filter = new ApiFilter("API-Key");
        filter.setAuthenticationManager(new ApiAuthenticationManager(value));

        http.csrf().
                disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and()
                .addFilter(filter)
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}