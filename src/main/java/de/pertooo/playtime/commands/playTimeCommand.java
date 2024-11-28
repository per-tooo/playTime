package de.pertooo.playtime.commands;

import de.pertooo.playtime.utilities.Files;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.sql.Timestamp;
import java.util.UUID;

public class playTimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player))
            return false;

        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();

        Files files = new Files(uuid.toString());
        FileConfiguration cfg = files.getFileConfiguration();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Long lastJoin = cfg.getLong("stats.lastJoin");
        Long playtime = cfg.getLong("stats.playtime");
        playtime = playtime + (timestamp.getTime() - lastJoin);

        player.sendMessage(
                "§7--------------------[§b§lPlayTime§7]--------------------",
                "§7These are your stats",
                "   §7Time played: §b" + playtime,
                "   §7Times Joined: §b" + cfg.getInt("stats.timesJoined"),
                "§7--------------------------------------------------"
        );

        return false;
    }
}
