package org.melonmc.meloneffects.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.melonmc.meloneffects.MelonEffects;
import org.melonmc.meloneffects.data.PlayerData;

public class Listeners implements Listener {
    private final MelonEffects plugin;
    public Listeners(MelonEffects plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onSound(PlayerDeathEvent e) {
        if(e.getEntity().getKiller() == null) {
            return;
        }
        if(e.getEntity().getName().equalsIgnoreCase(e.getEntity().getKiller().getName())) {
            return;
        }

        Player p = e.getEntity().getKiller();
        PlayerData playerData = PlayerData.getPlayerData(plugin, p.getUniqueId());
        Sound effect = playerData.getActiveSound().getSoundEffect();
        if(effect.equals(SoundEffect.NONE)) {
            return;
        }
        p.playSound(p.getLocation(), effect, 3, 1);
        plugin.getNearbyPlayers(p, plugin.getConfig().getDouble("SOUND_EFFECT_RADIUS")).forEach(i -> {
            i.playSound(p.getLocation(), effect, 3, 1);
        });
    }
}
