package de.pertooo.playtime.commands.playtime;

import de.pertooo.playtime.utilities.Files;
import de.pertooo.playtime.utilities.Timestamp;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ChatOutput {
    public static void playtimeOutput(Player player) {
        Files files = new Files(player.getUniqueId().toString());
        FileConfiguration cfg = files.getFileConfiguration();

        Long lastJoin = cfg.getLong("stats.lastJoin");
        Long playtime = cfg.getLong("stats.playtime");
        playtime = playtime + (Timestamp.getCurrentTimeStamp() - lastJoin);

        player.sendMessage(
                "",
                "§7These are your stats",
                "   §7Time played: §b" + Timestamp.parseTimestamp(playtime),
                "   §7Times Joined: §b" + cfg.getInt("stats.timesJoined"),
                ""
        );
    }

    public static void playtimeOutput(Player player, String targetUUID) {
        Files files = new Files(targetUUID);
        FileConfiguration cfg = files.getFileConfiguration();

        Long lastJoin = cfg.getLong("stats.lastJoin");
        Long playtime = cfg.getLong("stats.playtime");
        playtime = playtime + (Timestamp.getCurrentTimeStamp() - lastJoin);

        player.sendMessage(
                "",
                "§7These are " + Bukkit.getPlayer(targetUUID).getName() + "'s stats",
                "   §7Time played: §b" + Timestamp.parseTimestamp(playtime),
                "   §7Times Joined: §b" + cfg.getInt("stats.timesJoined"),
                ""
        );
    }

    public static void serverOutput(Player player) {
        Files files = new Files("server");
        FileConfiguration cfg = files.getFileConfiguration();

        Long lastStart = cfg.getLong("stats.lastStart");
        Long uptime = cfg.getLong("stats.uptime");
        uptime = uptime + (Timestamp.getCurrentTimeStamp() - lastStart);

        player.sendMessage(
                "",
                "§7These are the server's stats",
                "   §7Uptime: §b" + Timestamp.parseTimestamp(uptime),
                ""
        );
    }
}
