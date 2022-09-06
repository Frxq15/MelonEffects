package org.melonmc.meloneffects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.melonmc.meloneffects.data.DataListeners;
import org.melonmc.meloneffects.data.DataManager;

public final class MelonEffects extends JavaPlugin {
    private static MelonEffects instance;
    private FileManager fileManager;
    private DataManager dataManager;

    @Override
    public void onEnable() {
        instance = this;
        fileManager = new FileManager(this);
        dataManager = new DataManager(this);
        saveDefaultConfig();
        getFileManager().createDataFile();
        Bukkit.getPluginManager().registerEvents(new DataListeners(this), this);
        log("Plugin enabled.");

    }

    @Override
    public void onDisable() {
        log("Plugin disabled.");
    }
    public static MelonEffects getInstance() { return instance; }
    public static void log(String str) { Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"[MelonEffects] "+str); }
    public static String formatMsg(String input) {  return ChatColor.translateAlternateColorCodes('&', getInstance().getConfig().getString(input)); }
    public FileManager getFileManager() { return fileManager; }
    public DataManager getDataManager() { return dataManager; }
}
