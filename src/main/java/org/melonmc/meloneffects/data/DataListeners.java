package org.melonmc.meloneffects.data;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.melonmc.meloneffects.MelonEffects;

import java.util.UUID;

public class DataListeners implements Listener {
    private final MelonEffects plugin;
    public DataListeners(MelonEffects plugin) {
        this.plugin = plugin;
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onAsyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();
        if(plugin.getDataManager().playerExists(uuid)) return;
        plugin.getDataManager().createPlayer(uuid);
        PlayerData playerData = PlayerData.getPlayerData(plugin, uuid);
    }
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            UUID uuid = event.getPlayer().getUniqueId();
            PlayerData playerData = PlayerData.getPlayerData(plugin, uuid);
            playerData.uploadPlayerData(plugin);
            PlayerData.removePlayerData(uuid);
        });
    }
}
