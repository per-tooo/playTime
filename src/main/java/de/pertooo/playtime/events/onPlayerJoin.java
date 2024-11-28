package de.pertooo.playtime.events;

import de.pertooo.playtime.utilities.Files;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.Timestamp;
import java.util.UUID;

public class onPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        UUID uuid = player.getUniqueId();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Files files = new Files(uuid.toString());
        FileConfiguration cfg = files.getFileConfiguration();

        if (!files.fileExists()) {
            // create new user file
            cfg.set("stats.timesJoined", Integer.toString(1));
            cfg.set("stats.lastJoin", Long.toString(timestamp.getTime()));
            cfg.set("stats.playtime", Integer.toString(0));
        } else {
            cfg.set(
                    "stats.timesJoined",
                    Integer.toString(cfg.getInt("stats.timesJoined") + 1)
            );
            cfg.set("stats.lastJoin", Long.toString(timestamp.getTime()));
        }
    }
}
