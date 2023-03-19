package com.github.jessejes.blog.discord;

import com.github.jessejes.blog.discord.models.Config;
import com.github.jessejes.blog.discord.util.ConfigManager;
import com.github.jessejes.blog.discord.util.TokenManager;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        String discordToken = TokenManager.loadToken();

        DiscordClient.create(discordToken)
                .withGateway(client ->
                        client.on(MessageCreateEvent.class, event -> {

                            Message message = event.getMessage();

                            if (message.getContent().equalsIgnoreCase("!ping")) {
                                return message.getChannel()
                                        .flatMap(channel -> channel.createMessage("Pong!"));
                            }

                            return Mono.empty();
                        })).block();
    }
}
