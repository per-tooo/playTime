package de.pertooo.playtime.utilities;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Files {
    private String fileName;
    private File file;
    private FileConfiguration fileConfiguration;

    public Files(String fileName) {
        this.fileName = fileName + ".yml";
        this.file = new File("plugins//PlayTime//players", this.fileName);
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getFileConfiguration() { return this.fileConfiguration; }

    public boolean fileExists() { return this.file.isFile() && !this.file.isDirectory(); }

    public void saveFile() {
        try {
            this.fileConfiguration.save(this.file);
        } catch(Exception exception) {
            System.out.println("[ERROR] Could not save this file: " + this.fileName);
        }
    }
}
