package kalle.com.simplelifesteal;

import kalle.com.simplelifesteal.commands.AddHeartsCommand;
import kalle.com.simplelifesteal.events.PlayerDeath;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleLifeSteal extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerEvents();
        registerCommands();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SimpleLifeSteal] Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SimpleLifeSteal] Plugin has been disabled!");
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
    }

    public void registerCommands() {
        getCommand("addhearts").setExecutor(new AddHeartsCommand());
    }

}
