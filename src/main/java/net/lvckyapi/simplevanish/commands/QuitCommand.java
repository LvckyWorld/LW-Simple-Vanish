package net.lvckyapi.simplevanish.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * © 2016-2021 LvckyWorld Infastructure Systems
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish.commands
 **/
public class QuitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 && sender instanceof Player) {
            Player p = (Player) sender;
            p.kickPlayer("\n" +
                    "§7LvckyWorld\n" +
                    "\n" +
                    "§eSuccessfully Quited");
        } else {
            sender.sendMessage("§cERROR");
        }
        return false;
    }
}
