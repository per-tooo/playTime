package de.pertooo.playtime;

import de.pertooo.playtime.commands.playTimeCommand;
import de.pertooo.playtime.events.onPlayerJoin;
import de.pertooo.playtime.events.onPlayerQuit;
import de.pertooo.playtime.utilities.Files;
import de.pertooo.playtime.utilities.Timestamp;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayTime extends JavaPlugin {
    private Files files = new Files("server");
    private FileConfiguration cfg = files.getFileConfiguration();

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (this.files.fileExists())
            this.cfg.set("stats.uptime", Integer.toString(0));
        this.cfg.set("stats.lastStart", Long.toString(Timestamp.getCurrentTimeStamp()));
        this.files.saveFile();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Long lastStart = this.cfg.getLong("stats.lastStart");
        Long timestamp = Timestamp.getCurrentTimeStamp();
        this.cfg.set("stats.uptime", Long.toString(timestamp - lastStart));
        this.files.saveFile();
    }

    private void registerCommands() {
        getCommand("playtime").setExecutor(new playTimeCommand());
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new onPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new onPlayerQuit(), this);
    }
}
