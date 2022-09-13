package org.melonmc.meloneffects.data;

import org.bukkit.Bukkit;
import org.melonmc.meloneffects.MelonEffects;
import org.melonmc.meloneffects.effects.KillEffect;
import org.melonmc.meloneffects.utils.SoundEffect;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {
    private final static Map<UUID, PlayerData> players = new HashMap<>();
    private final UUID uuid;
    private SoundEffect soundEffect;
    private KillEffect killEffect;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        players.put(uuid, this);
    }

    public void setActiveSound(SoundEffect effect) {
        this.soundEffect = effect;
    }
    public void setActiveEffect(KillEffect effect) {
        this.killEffect = effect;
    }
    public SoundEffect getActiveSound() {
        return soundEffect;
    }
    public KillEffect getActiveEffect() {
        return killEffect;
    }

    public static void removePlayerData(UUID uuid) { players.remove(uuid); }
    public static PlayerData getPlayerData(MelonEffects plugin, UUID uuid) {
        if (!players.containsKey(uuid)) {
            PlayerData playerData = new PlayerData(uuid);
            playerData.setActiveSound(SoundEffect.valueOf(plugin.getDataManager().getActiveSound(uuid)));
            playerData.setActiveEffect(KillEffect.valueOf(plugin.getDataManager().getActiveEffect(uuid)));
        }
        return players.get(uuid);
    }
    public void uploadPlayerData(MelonEffects plugin) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> plugin.getDataManager().setActiveSound(uuid, getActiveSound()));
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> plugin.getDataManager().setActiveEffect(uuid, getActiveEffect()));
    }
    public static Map<UUID, PlayerData> getAllPlayerData() {
        return players;
    }
}
