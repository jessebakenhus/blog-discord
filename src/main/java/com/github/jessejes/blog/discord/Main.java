package com.github.jessejes.blog.discord;

import com.github.jessejes.blog.discord.models.Config;
import com.github.jessejes.blog.discord.util.ConfigManager;
import com.github.jessejes.blog.discord.util.EmbedFactory;
import com.github.jessejes.blog.discord.util.TokenManager;
import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.GuildMessageChannel;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.RestClient;
import reactor.core.publisher.Mono;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        String discordToken = TokenManager.loadToken();
        Config config = ConfigManager.loadConfig();

        GatewayDiscordClient client = DiscordClientBuilder.create(discordToken)
                .build()
                .login()
                .block();

        client.getChannelById(config.getNotifyChannelId())
                .ofType(GuildMessageChannel.class)
                .flatMap(channel -> channel.createMessage(MessageCreateSpec.builder()
                        .content("Hello! Love you all <3")
                        .build()
                )).subscribe();

        client.onDisconnect().block();
    }
}
