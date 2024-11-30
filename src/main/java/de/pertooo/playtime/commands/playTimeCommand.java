package de.pertooo.playtime.commands;

import de.pertooo.playtime.commands.playtime.ChatOutput;
import de.pertooo.playtime.commands.playtime.Help;
import de.pertooo.playtime.utilities.Files;
import org.bukkit.Bukkit;
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

        if (strings.length == 0) {
            ChatOutput.playtimeOutput(player);
        }
        if (strings.length == 1) {
            // /playtime <arg>

            if (strings[0].equalsIgnoreCase("help")) {
                Help.helpOutput(player);
                return true;
            }

            if (strings[0].equalsIgnoreCase("server")) {
                ChatOutput.serverOutput(player);
                return true;
            }

            ChatOutput.playtimeOutput(player, Bukkit.getPlayer(strings[0]).getUniqueId().toString());
        }
        return false;
    }
}
