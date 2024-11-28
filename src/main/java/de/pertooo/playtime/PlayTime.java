package de.pertooo.playtime;

import de.pertooo.playtime.events.onPlayerJoin;
import de.pertooo.playtime.events.onPlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayTime extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {}

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new onPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new onPlayerQuit(), this);
    }
}
