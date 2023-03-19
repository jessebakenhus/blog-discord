package com.github.jessejes.blog.discord.converter;

import com.github.jessejes.blog.discord.models.Settings;
import com.github.jessejes.blog.discord.models.SettingsPersistenceDto;
import discord4j.common.util.Snowflake;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SettingsPersistenceDtoConverter {

    public Settings fromDto(SettingsPersistenceDto settingsPersistenceDto) {
        return new Settings(
                Snowflake.of(settingsPersistenceDto.getNotifyChannelId()),
                AuthorPersistenceDtoConverter.fromDto(settingsPersistenceDto.getAuthor()),
                settingsPersistenceDto.getContent()
        );
    }
}
