package org.melonmc.meloneffects.data;

import org.melonmc.meloneffects.MelonEffects;
import org.melonmc.meloneffects.effects.KillEffect;
import org.melonmc.meloneffects.utils.SoundEffect;

import java.util.UUID;

public class DataManager {
    private final MelonEffects plugin;
    public DataManager(MelonEffects plugin) {
        this.plugin = plugin;
    }
    public void createPlayer(UUID uuid) {
        plugin.getFileManager().getDataFile().set(uuid + ".ACTIVE_SOUND", "NONE");
        plugin.getFileManager().getDataFile().set(uuid + ".ACTIVE_EFFECT", "NONE");
        plugin.getFileManager().saveDataFile();
    }
    public String getActiveSound(UUID uuid) {
        return plugin.getFileManager().getDataFile().getString(uuid + ".ACTIVE_SOUND");
    }
    public String getActiveEffect(UUID uuid) {
        return plugin.getFileManager().getDataFile().getString(uuid + ".ACTIVE_EFFECT");
    }
    public void setActiveSound(UUID uuid, SoundEffect effect) {
        plugin.getFileManager().getDataFile().set(uuid + ".ACTIVE_SOUND", effect.name());
        plugin.getFileManager().saveDataFile();
    }
    public void setActiveEffect(UUID uuid, KillEffect effect) {
        plugin.getFileManager().getDataFile().set(uuid + ".ACTIVE_EFFECT", effect.name());
        plugin.getFileManager().saveDataFile();
    }
    public boolean playerExists(UUID uuid) {
        return plugin.getFileManager().getDataFile().isConfigurationSection(String.valueOf(uuid));
    }
}
