package com.github.jessejes.blog.discord.util.config;

import com.github.jessejes.blog.discord.models.Config;
import com.github.jessejes.blog.discord.models.ConfigPersistenceDto;
import discord4j.common.util.Snowflake;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigPersistenceDtoConverter {

    public Config fromDto(ConfigPersistenceDto configPersistenceDto) {
        return new Config(Snowflake.of(configPersistenceDto.getNotifyChannelId()));
    }
}
