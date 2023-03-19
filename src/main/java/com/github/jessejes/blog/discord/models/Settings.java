package com.github.jessejes.blog.discord.models;

import discord4j.common.util.Snowflake;
import lombok.Value;

@Value
public class Settings {

    Snowflake notifyChannelId;

    Author author;

    String content;

}