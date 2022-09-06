package org.melonmc.meloneffects;

import org.bukkit.plugin.java.JavaPlugin;

public final class MelonEffects extends JavaPlugin {
    private static MelonEffects instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static MelonEffects getInstance() { return instance; }
}
