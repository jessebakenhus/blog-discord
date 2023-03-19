package com.github.jessejes.blog.discord.util;

import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class TokenManager {

    public String loadToken() {

        Map<String, String> getenv = System.getenv();

        return getenv.get("DISCORD_TOKEN");
    }
}
