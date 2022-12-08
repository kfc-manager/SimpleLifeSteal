package kalle.com.simplelifesteal.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddHeartsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "[SimpleLifeSteal] You do not have the permission to execute this command!");
            return true;
        }
        if (args.length < 2 || args.length > 2) {
            sender.sendMessage(ChatColor.RED + "[SimpleLifeSteal] The command requires exactly two arguments!");
            return false;
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().equals(args[1])) {
                try {
                    int amount = Integer.parseInt(args[0]);
                    double value = amount * 2.0;
                    if (player.getMaxHealth() + value < 2.0) {
                        sender.sendMessage(ChatColor.RED + "[SimpleLifeSteal] The health of player " + ChatColor.GOLD + args[1] + ChatColor.RED + " would be lower than one!");
                        return true;
                    }
                    player.setMaxHealth(player.getMaxHealth() + value);
                    sender.sendMessage(ChatColor.GREEN + "[SimpleLifeSteal] " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " hearts have been added to player " + ChatColor.GOLD + args[1] + ChatColor.GREEN + "!");
                    return true;
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "[SimpleLifeSteal] The first argument needs to be an integer!");
                    return false;
                }
            }
        }
        sender.sendMessage(ChatColor.RED + "[SimpleLifeSteal] The player " + ChatColor.GOLD + args[1] + ChatColor.RED + " is not online!");
        return true;
    }

}
