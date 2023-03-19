package com.github.jessejes.blog.discord.models;

import discord4j.common.util.Snowflake;
import lombok.Builder;
import lombok.Value;

@Value
public class Config {

    Snowflake notifyChannelId;

}