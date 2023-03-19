package com.github.jessejes.blog.discord;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class GatewayDiscordConfiguration {

    @Bean
    public GatewayDiscordClient gatewayDiscordClient() {

        Map<String, String> getenv = System.getenv();
        String token = getenv.get("DISCORD_TOKEN");

        GatewayDiscordClient client = DiscordClientBuilder.create(token)
                .build()
                .login()
                .block();

        return client;
    }
}