package com.github.jessejes.blog.discord.models;

import lombok.Value;

@Value
public class AuthorPersistenceDto {

    String name;
    String url;
    String iconUrl;
}
