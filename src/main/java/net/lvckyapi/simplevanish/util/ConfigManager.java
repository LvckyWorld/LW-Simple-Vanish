package net.lvckyapi.simplevanish.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * © 2016-2021 LvckyWorld Media
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish.util
 **/
public class ConfigManager {
    private static File getFile() {
        return new File("plugins/SimpleVanish", "mainConf.yml");
    }

    private static FileConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    private static void loadConfig() {
        if (!getFile().exists()) {
            FileConfiguration cfg = getConfiguration();
            cfg.set("language", "de");
            try {
                cfg.save(getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            /* Laden der Configuration für Commands */
        }
    }
}
