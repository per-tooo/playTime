package de.pertooo.playtime.events;

import de.pertooo.playtime.utilities.Files;
import de.pertooo.playtime.utilities.Timestamp;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class onPlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        UUID uuid = player.getUniqueId();

        Files files = new Files(uuid.toString());
        FileConfiguration cfg = files.getFileConfiguration();

        Long timestamp = Timestamp.getCurrentTimeStamp();

        if (!files.fileExists()) {
            // create new user file
            cfg.set("stats.timesJoined", 1);
            cfg.set("stats.lastJoin", timestamp);
            cfg.set("stats.playtime", 0);
        } else {
            cfg.set(
                    "stats.timesJoined",
                    cfg.getInt("stats.timesJoined") + 1
            );
            cfg.set("stats.lastJoin", timestamp);
        }
        files.saveFile();
    }
}
