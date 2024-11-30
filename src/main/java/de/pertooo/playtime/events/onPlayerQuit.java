package de.pertooo.playtime.events;

import de.pertooo.playtime.utilities.Files;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.Timestamp;
import java.util.UUID;

public class onPlayerQuit implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        UUID uuid = player.getUniqueId();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Files files = new Files(uuid.toString());
        FileConfiguration cfg = files.getFileConfiguration();

        Long lastJoin = cfg.getLong("stats.lastJoin");
        Long playtime = cfg.getLong("stats.playtime");
        playtime = playtime + (timestamp.getTime() - lastJoin);
        cfg.set("stats.playtime", Long.toString(playtime));

        files.saveFile();
    }
}
