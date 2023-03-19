package com.github.jessejes.blog.discord.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ConfigPersistenceDto {

    String notifyChannelId;
}
