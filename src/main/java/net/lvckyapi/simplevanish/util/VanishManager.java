package net.lvckyapi.simplevanish.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * © 2016-2021 LvckyWorld Infastructure Systems
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish.util
 **/
public class VanishManager {
    public static ArrayList<String> vanishedPlayers = new ArrayList<>();

    public static void setVanish(Player p) {
        if (!vanishedPlayers.contains(p.getName())) {
            vanishedPlayers.add(p.getName());
            Bukkit.getOnlinePlayers().forEach(all -> {
                if (!all.hasPermission("sv.seeothers")) {
                    all.hidePlayer(p);
                }
            });
        }
    }
    public static void removeVanish(Player p) {
        if (vanishedPlayers.contains(p.getName())) {
            vanishedPlayers.remove(p.getName());
            Bukkit.getOnlinePlayers().forEach(all -> all.showPlayer(p));
        }
    }
    public static boolean isVanished(Player p) {
        return vanishedPlayers.contains(p.getName());
    }
    public static String getVanishedPlayer(Player p) {
        if (vanishedPlayers.isEmpty()) {
            return "§cKeine Spieler im Vanish";
        }
        if (vanishedPlayers.contains(p.getName())) {
            return p.getName();
        } else {
            return null;
        }
    }
}
