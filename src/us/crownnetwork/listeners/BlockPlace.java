package us.crownnetwork.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import us.crownnetwork.Main;

public class BlockPlace implements Listener {

	private Main plugin;
	
	public BlockPlace(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		ItemStack i = e.getItemInHand();
		
		if (!i.hasItemMeta())
			return;
		
		Player p = e.getPlayer();
		
		if (i.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Compressed Stone")) {
			e.setCancelled(true);
			
			plugin.sendMessage(p, ChatColor.RED + "Commpressed Stone is an item not a block.");
		}
		
		else if (i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1) ")) {
			e.setCancelled(true);
			
			plugin.sendMessage(p, ChatColor.RED + "You can't place a backpack on the ground!");
		}
		
		else if (i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1)")) {
			e.setCancelled(true);
			
			plugin.sendMessage(p, ChatColor.RED + "You can't place a backpack on the ground!");
		}
		
		else if (i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)")) {
			e.setCancelled(true);
			
			plugin.sendMessage(p, ChatColor.RED + "You can't place a backpack on the ground!");
		}
	}
	
}
