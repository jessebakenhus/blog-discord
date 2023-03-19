package com.github.jessejes.blog.discord.configurations;

import com.github.jessejes.blog.discord.models.Settings;
import com.github.jessejes.blog.discord.models.SettingsPersistenceDto;
import com.github.jessejes.blog.discord.converter.SettingsPersistenceDtoConverter;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Configuration
public class SettingsConfiguration {

    private final Gson GSON = new Gson();

    @Bean
    public Settings settings() {

        ClassLoader classLoader = SettingsConfiguration.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("settings.json");

        try(Reader reader = new InputStreamReader(inputStream)) {

            SettingsPersistenceDto persistenceDto = GSON.fromJson(reader, SettingsPersistenceDto.class);

            return SettingsPersistenceDtoConverter.fromDto(persistenceDto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
