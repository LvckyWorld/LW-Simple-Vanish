package net.lvckyapi.simplevanish;

import net.lvckyapi.simplevanish.commands.QuitCommand;
import net.lvckyapi.simplevanish.commands.VanishCommad;
import net.lvckyapi.simplevanish.listener.MainListener;
import net.lvckyapi.simplevanish.util.ConfigManager;
import net.lvckyapi.simplevanish.util.Utility;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * © 2016-2021 LvckyWorld Media
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish
 **/
public class SimpleVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager.startUp();
        Bukkit.broadcastMessage(Utility.getPrefix() + "§ePlugin wurde erfolgreich aktiviert!");
        getCommand("vanish").setExecutor(new VanishCommad());
        getCommand("quit").setExecutor(new QuitCommand());
        Bukkit.getPluginManager().registerEvents(new MainListener(), this);
        super.onEnable();
    }
}
