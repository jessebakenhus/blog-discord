//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.github.jessejes.blog.discord.util;

import com.github.jessejes.blog.discord.models.Config;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class ConfigManager {
    private static final Gson GSON = new Gson();

    public static Config loadConfig() {

        ClassLoader classLoader = ConfigManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("config.json");

        try(Reader reader = new InputStreamReader(inputStream)) {

            return GSON.fromJson(reader, Config.class);

        } catch (IOException var7) {
            throw new RuntimeException(var7);
        }
    }
}
