package com.github.jessejes.blog.discord;

import com.github.jessejes.blog.discord.models.Config;
import com.github.jessejes.blog.discord.util.ConfigManager;
import com.github.jessejes.blog.discord.util.EmbedManager;
import com.github.jessejes.blog.discord.util.TokenManager;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.GuildMessageChannel;
import discord4j.core.spec.MessageCreateSpec;

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
                        .content("@everyone A new blog was published 📖")
                        .addEmbed(EmbedManager.createBlogEmbed("Hooked: How to Build Habit-Forming Products",
                                "Hooked provides a useful framework on how tech products build lasting habits in their users. Understanding this is useful for product designers and users alike. " +
                                        "The core of the Hooked model is the 4-step feedback loop: Trigger, Action, Reward, and Investment.",
                                "https://jessebakenhus.com/blog/lorem-ipsum"))
                        .build()
                )).subscribe();

        client.onDisconnect().block();
    }
}
