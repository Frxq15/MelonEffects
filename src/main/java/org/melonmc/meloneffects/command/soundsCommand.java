package org.melonmc.meloneffects.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.melonmc.meloneffects.MelonEffects;

public class soundsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            MelonEffects.log("This command cannot be executed from console.");
            return true;

        }
        Player p = (Player) sender;
        if(!p.hasPermission("meloneffects.sounds")) {
            MelonEffects.formatMsg("NO_PERMISSION");
            return true;
        }
        return true;
    }
}
