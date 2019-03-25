package me.arvinrhen.BSFix;

import org.bukkit.plugin.java.JavaPlugin;

import me.arvinrhen.BSFix.Events.EventsClass;
import net.md_5.bungee.api.ChatColor;

public class BSFix extends JavaPlugin {

	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "BSFix has been Enabled!");
		getServer().getPluginManager().registerEvents(new EventsClass(), this);
		loadConfig();
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "BSFix has been Disabled!");
	}
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}
}

