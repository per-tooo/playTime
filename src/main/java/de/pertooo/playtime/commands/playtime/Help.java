package de.pertooo.playtime.commands.playtime;

import org.bukkit.entity.Player;

public class Help {
    public static void helpOutput(Player player) {
        player.sendMessage(
                "§7--------------------[§b§lPlayTime§7]--------------------",
                "§7How to use:",
                "   §b/playtime - §7view your current playtime",
                "   §b/playtime server - §7view the servers current uptime",
                "   §b/playtime <user> - §7view another users current playtime",
                "§7--------------------------------------------------"
        );
    }
}
