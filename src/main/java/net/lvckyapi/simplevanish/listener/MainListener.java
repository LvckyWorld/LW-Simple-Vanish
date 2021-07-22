package net.lvckyapi.simplevanish.listener;

import net.lvckyapi.simplevanish.util.Utility;
import net.lvckyapi.simplevanish.util.VanishManager;
import net.lvckyapi.simplevanish.util.VariableManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * © 2016-2021 LvckyWorld Media
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish.listener
 **/
public class MainListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (VanishManager.vanishedPlayers.contains(e.getPlayer().getName())) {
            e.setJoinMessage(null);
            e.getPlayer().sendMessage(VariableManager.nowInVanish());
        }
        Bukkit.getOnlinePlayers().forEach(all -> {
            VanishManager.vanishedPlayers.forEach(vPs -> {
                Player x = Bukkit.getPlayer(vPs);
                if (!all.hasPermission("sv.seeothers")) {
                    all.hidePlayer(x);
                }
            });
        });
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (VanishManager.vanishedPlayers.contains(e.getPlayer().getName())) {
            e.setQuitMessage(null);
        }
        Bukkit.getOnlinePlayers().forEach(all -> {
            VanishManager.vanishedPlayers.forEach(vPs -> {
                Player x = Bukkit.getPlayer(vPs);
                if (!all.hasPermission("sv.seeothers")) {
                    all.hidePlayer(x);
                }
            });
        });

        if (Utility.aPC.contains(e.getPlayer().getName())) {
            Utility.aPC.remove(e.getPlayer().getName());
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (e.getMessage().equalsIgnoreCase("allow chat")) {
            if (p.hasPermission("sv.chat")) {
                if (!Utility.aPC.contains(p.getName())) {
                    e.setCancelled(true);
                    p.sendMessage(Utility.getPrefix() + "§7 Du kannst nun §aim Chat schreiben.");
                    Utility.aPC.add(p.getName());
                } else {
                    e.setCancelled(true);
                    p.sendMessage(Utility.getPrefix() + "§7Du kannst bereits schreiben.");
                }
            }
        }
        if (!Utility.aPC.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(Utility.getPrefix() + "§7Aktuell bist du im Vanish. Um nicht aufzufallen wurde deine Chatnachricht abgebrochen.");
            p.sendMessage(Utility.getPrefix() + "§7Solltest du dennoch nachrichten schreiben wollen, schreibe§e 'allow chat'§7!");
        }
    }
}
