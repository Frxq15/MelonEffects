package org.melonmc.meloneffects;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private final MelonEffects plugin;
    public File DataFile;
    public FileConfiguration DataConfig;

    public FileManager(MelonEffects plugin) {
        this.plugin = plugin;
    }
    public void createDataFile() {
        DataFile = new File(plugin.getInstance().getDataFolder(), "data.yml");
        if (!DataFile.exists()) {
            DataFile.getParentFile().mkdirs();
            plugin.log("data.yml was created successfully");
            plugin.getInstance().saveResource("data.yml", false);
        }

        DataConfig = new YamlConfiguration();
        try {
            DataConfig.load(DataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void reloadDataFile() { DataConfig = YamlConfiguration.loadConfiguration(DataFile); }
    public void saveDataFile() {
        try {
            DataConfig.save(DataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public FileConfiguration getDataFile() { return DataConfig; }
}
