package org.melonmc.meloneffects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.melonmc.meloneffects.command.soundsCommand;
import org.melonmc.meloneffects.data.DataListeners;
import org.melonmc.meloneffects.data.DataManager;
import org.melonmc.meloneffects.utils.Listeners;

import java.util.ArrayList;

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
        Bukkit.getPluginManager().registerEvents(new Listeners(this), this);
        getCommand("sounds").setExecutor(new soundsCommand());
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

    public ArrayList<Player> getNearbyPlayers(Player p, double range){
        ArrayList<Player> nearby = new ArrayList<Player>();
        for (Entity e : p.getNearbyEntities(range, range, range)){
            if (e instanceof Player){
                nearby.add((Player) e);
            }
        }
        return nearby;
    }
}
