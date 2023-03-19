package com.github.jessejes.blog.discord.converter;

import com.github.jessejes.blog.discord.models.Author;
import com.github.jessejes.blog.discord.models.AuthorPersistenceDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorPersistenceDtoConverter {

    public Author fromDto(AuthorPersistenceDto authorPersistenceDto) {
        return new Author(
                authorPersistenceDto.getName(),
                authorPersistenceDto.getUrl(),
                authorPersistenceDto.getIconUrl()
        );
    }
}
