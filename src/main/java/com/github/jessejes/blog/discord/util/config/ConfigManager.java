package com.github.jessejes.blog.discord.util.config;

import com.github.jessejes.blog.discord.models.Config;
import com.github.jessejes.blog.discord.models.ConfigPersistenceDto;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@UtilityClass
public class ConfigManager {
    private final Gson GSON = new Gson();

    public Config loadConfig() {

        ClassLoader classLoader = ConfigManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("config.json");

        try(Reader reader = new InputStreamReader(inputStream)) {

            ConfigPersistenceDto persistenceDto = GSON.fromJson(reader, ConfigPersistenceDto.class);

            return ConfigPersistenceDtoConverter.fromDto(persistenceDto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
