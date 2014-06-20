package us.crownnetwork.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import us.crownnetwork.Main;

public class InventoryClick implements Listener {

	private Main plugin;
	
	public InventoryClick(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		if (!(e.getWhoClicked() instanceof Player))
			return;
		
		Player p = (Player) e.getWhoClicked();
		
		int packs = 0;
		
		for (ItemStack i : e.getWhoClicked().getInventory().getContents()) {
			
			if (i == null || !i.hasItemMeta())
				continue;
			
			String name = i.getItemMeta().getDisplayName();
			
			if (name.equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1)") 
					|| name.equals(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)"))
				packs++;
		}
		
		if (packs > 1) {
			e.setCancelled(true);
			plugin.sendMessage(p, ChatColor.RED + "You cannot have more then one backpack in your inventory.");
		}
		
	}
}
