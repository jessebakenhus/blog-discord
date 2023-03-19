package com.github.jessejes.blog.discord.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class Blog {

    @Getter
    private final String title;

    @Getter
    private final String description;

    @Getter
    private final  String url;

    @JsonCreator
    public Blog(@JsonProperty("title") String title,
                @JsonProperty("description") String description,
                @JsonProperty("url") String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }
}
