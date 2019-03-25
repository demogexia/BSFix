package me.arvinrhen.BSFix.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.arvinrhen.BSFix.BSFix;
import net.md_5.bungee.api.ChatColor;

public class EventsClass implements Listener {
	private Plugin plugin = BSFix.getPlugin(BSFix.class);
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
	    ItemStack item = event.getItemDrop().getItemStack();
	    
	    if (item == null) {
            return;
        }

        if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return;
        }
        
	    String name = item.getItemMeta().getDisplayName();
	    
	    if (name.equals(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Name")))) {
	    	//event.getPlayer().sendMessage(ChatColor.RED + "Remove Black Scroll to your Inventory!");
	        event.setCancelled(true);
	        
	        //"§8\u25C6 §8§nBlack Scroll§r §8\u25C6"
	    }
	}
	@EventHandler
	public void onOpenInventory(InventoryOpenEvent event) {
		for (ItemStack i : event.getPlayer().getInventory().getContents()) {
			if (i == null) {
	            return;
	        }
			
            if(i.getType() == Material.INK_SACK && i.hasItemMeta() && i.getItemMeta().hasDisplayName()
                    && i.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Name")))) {
            	if (event.getInventory().getType() == InventoryType.ANVIL) {
            		event.getPlayer().sendMessage(ChatColor.RED + "Remove Black Scroll to your Inventory!");
           			event.setCancelled(true);
            	}
            }
		}
	} 
}

