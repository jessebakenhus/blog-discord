package com.github.jessejes.blog.discord.controller;

import com.github.jessejes.blog.discord.models.Blog;
import com.github.jessejes.blog.discord.models.Config;
import com.github.jessejes.blog.discord.util.config.ConfigManager;
import com.github.jessejes.blog.discord.util.discord4j.EmbedManager;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.GuildMessageChannel;
import discord4j.core.spec.MessageCreateSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    GatewayDiscordClient gatewayDiscordClient;

    @PostMapping("/blog")
    public void postBlog(@RequestBody Blog blog) {

        Config config = ConfigManager.loadConfig();

        gatewayDiscordClient.getChannelById(config.getNotifyChannelId())
                .ofType(GuildMessageChannel.class)
                .flatMap(channel -> channel.createMessage(MessageCreateSpec.builder()
                        .content("@everyone A new blog was published 📖")
                        .addEmbed(EmbedManager.createBlogEmbed(blog.getTitle(), blog.getDescription(), blog.getUrl()))
                        .build()
                )).subscribe();
    }
}
