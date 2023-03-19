package com.github.jessejes.blog.discord.util;

import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import lombok.experimental.UtilityClass;

import java.time.Instant;

@UtilityClass
public class EmbedManager {

    public EmbedCreateSpec createBlogEmbed(String blogTitle, String blogDescription, String blogUrl) {

        return EmbedCreateSpec.builder()
                .color(Color.ORANGE)
                .title(blogTitle)
                .description(blogDescription)
                .timestamp(Instant.now())
                .url(blogUrl)
                .author("jesse bakenhus", "https://jessebakenhus.com", "https://avatars.githubusercontent.com/u/92591280")
                .build();
    }
}
