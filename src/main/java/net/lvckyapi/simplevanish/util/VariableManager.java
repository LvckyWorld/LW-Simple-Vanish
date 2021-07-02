package net.lvckyapi.simplevanish.util;

import com.sun.istack.internal.NotNull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

/**
 * © 2016-2021 LvckyWorld Infastructure Systems
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish.util
 **/
public class VariableManager {

    private static File getFile() {
        return new File("plugins/SimpleVanish", "mainConf.yml");
    }
    private static FileConfiguration getConfiguration() {
        return YamlConfiguration.loadConfiguration(getFile());
    }
    private static Boolean german() {
        if (getConfiguration().getString("language").equalsIgnoreCase("de")) {
            return true;
        } else
            return false;
    }
    private static Boolean english () {
        if (getConfiguration().getString("language").equalsIgnoreCase("eng")) {
            return true;
        } else
            return false;
    }
    @NotNull
    public static String cmdArgError(String label) {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§7Mache §e" + label + " §7 oder §e/" + label + " [NAME]§7!";
        }
        if (english()) {
            return Utility.getPrefix() + "§7Make §e" + label + " §7 or §e/" + label + " [NAME]§7!";
        }
        return null;
    }
    @NotNull
    public static String nowNoLonerVanish() {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§7Du bist nun§c nicht mehr§7 Vanish.";
        }
        if (english()) {
            return Utility.getPrefix() + "§7You are now§c no longer§7 Vanish.";
        }
        return null;
    }
    @NotNull
    public static String permsError(String permsThatAreRequired) {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§7Dazu hast du keine Rechte, dir fehlt§e " + permsThatAreRequired;
        }
        if (english()) {
            return Utility.getPrefix() + "§7You have no rights to this, you lack§e " + permsThatAreRequired;
        }
        return null;
    }
    @NotNull
    public static String nowInVanish() {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§7Du bist nun §a im §7 Vanish.";
        }
        if (english()) {
            return Utility.getPrefix() + "§7You are now §ain§7 Vanish.";
        }
        return null;
    }

    @NotNull
    public static String playerNotOnline(String player) {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§cDer Spieler §e" + player +  "§c ist nicht online.";
        }
        if (english()) {
            return Utility.getPrefix() + "§cThe player §e" + player +"§c is not online.";
        }
        return null;
    }

    @NotNull
    public static String unVanishOthers(Player t) {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§e" + t.getName() + "§7 ist nun§c nicht mehr§7 im Vanish.";
        }
        if (english()) {
            return Utility.getPrefix() + "§e" + t.getName() + "§7 is now§c not longer§7 in Vanish.";
        }
        return null;
    }

    @NotNull
    public static String vanishOthers(Player t) {
        if (german() && english()) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        } else if (!(german() && english())) {
            return Utility.getPrefix() + "§4CRITICAL LANGUAGE CONFIG ERROR / KRITISCHER SPRACHKONIGURATIONS FEHLER";
        }
        if (german()) {
            return Utility.getPrefix() + "§e" + t.getName() + "§7 ist nun§a im§7 Vanish.";
        }
        if (english()) {
            return Utility.getPrefix() + "§e" + t.getName() + "§7 is now§a in§7 Vanish.";
        }
        return null;
    }

}
