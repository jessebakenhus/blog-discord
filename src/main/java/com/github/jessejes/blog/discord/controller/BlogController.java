package com.github.jessejes.blog.discord.controller;

import com.github.jessejes.blog.discord.models.Author;
import com.github.jessejes.blog.discord.models.Blog;
import com.github.jessejes.blog.discord.models.Settings;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.channel.GuildMessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.core.spec.MessageCreateSpec;
import discord4j.rest.util.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class BlogController {

    @Autowired
    GatewayDiscordClient gatewayDiscordClient;

    @Autowired
    Settings settings;

    @PostMapping("/notify")
    public void postBlog(@RequestBody Blog blog) {

        Author author = settings.getAuthor();

        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .color(Color.ORANGE)
                .title(blog.getTitle())
                .description(blog.getDescription())
                .url(blog.getUrl())
                .timestamp(Instant.now())
                .author(author.getName(), author.getUrl(), author.getIconUrl())
                .build();

        gatewayDiscordClient.getChannelById(settings.getNotifyChannelId())
                .ofType(GuildMessageChannel.class)
                .flatMap(channel -> channel.createMessage(MessageCreateSpec.builder()
                        .content("@everyone A new blog was published 📖")
                        .addEmbed(embed)
                        .build()
                )).subscribe();
    }
}
