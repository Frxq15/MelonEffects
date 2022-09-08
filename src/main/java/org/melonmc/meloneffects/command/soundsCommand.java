package org.melonmc.meloneffects.command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.melonmc.meloneffects.MelonEffects;
import org.melonmc.meloneffects.data.PlayerData;
import org.melonmc.meloneffects.utils.SoundEffect;

public class soundsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            MelonEffects.log("This command cannot be executed from console.");
            return true;

        }
        Player p = (Player) sender;
        if (!p.hasPermission("meloneffects.sounds")) {
            MelonEffects.formatMsg("NO_PERMISSION");
            return true;
        }
        if (args.length == 0) {
            PlayerData playerData = PlayerData.getPlayerData(MelonEffects.getInstance(), p.getUniqueId());
            playerData.setActiveSound(SoundEffect.EXPLOSION);
            Bukkit.broadcastMessage("active: " + playerData.getActiveSound());
            Sound effect = playerData.getActiveSound().getSoundEffect();
            if (effect.equals(SoundEffect.NONE)) {
                return true;
            }
            p.playSound(p.getLocation(), effect, 3, 1);
            return true;
        }
        if(args.length == 1) {
            String sound = args[0];
            p.playSound(p.getLocation(), Sound.valueOf(sound), 3, 1);
            return true;
        }
        return true;
    }
}
