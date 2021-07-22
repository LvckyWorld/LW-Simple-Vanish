package net.lvckyapi.simplevanish.commands;

import net.lvckyapi.simplevanish.util.Utility;
import net.lvckyapi.simplevanish.util.VanishManager;
import net.lvckyapi.simplevanish.util.VariableManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * © 2016-2021 LvckyWorld Media
 * Licensed to Iven Schlenther and Lukas Oetken
 * DO NOT CHANGE!
 * Projekt: LW-Simple-Vanish
 * Package: net.lvckyapi.simplevanish.commands
 **/
public class VanishCommad implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("sv.use")) {
                if (args.length == 0) {
                    if (VanishManager.isVanished(p)) {
                        VanishManager.removeVanish(p);
                        p.sendMessage(VariableManager.nowNoLonerVanish());
                    } else {
                        VanishManager.setVanish(p);
                        p.sendMessage(VariableManager.nowInVanish());
                    }

                } else if (args.length == 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if (!p.hasPermission("sv.others")) {
                        p.sendMessage(VariableManager.permsError("sv.others"));
                        return false;
                    }
                    if (t != null) {
                        if (VanishManager.isVanished(t)) {
                            VanishManager.removeVanish(t);
                            t.sendMessage(VariableManager.nowNoLonerVanish());
                            p.sendMessage(VariableManager.unVanishOthers(t));
                        } else {
                            VanishManager.setVanish(t);
                            t.sendMessage(VariableManager.nowInVanish());
                            p.sendMessage(VariableManager.vanishOthers(t));
                        }
                    } else {
                        p.sendMessage(VariableManager.playerNotOnline(args[0]));
                    }
                } else {
                    p.sendMessage(VariableManager.cmdArgError(label));
                }
            } else {
                p.sendMessage(VariableManager.permsError("sv.use"));
            }
        } else {
            sender.sendMessage("YOU MUST BE APLAYER");
        }
        return false;
    }
}
