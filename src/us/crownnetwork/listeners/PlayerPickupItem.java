package us.crownnetwork.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerPickupItem implements Listener {

	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e) {
		
		Player p = e.getPlayer();
		
		int packs = 0;
		
		for (ItemStack i : p.getInventory().getContents()) {
			
			if (i== null || !i.hasItemMeta())
				continue;
			
			String name = i.getItemMeta().getDisplayName();
			
			if (name.equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1)") 
					|| name.equals(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)"))
				packs++;
		}
		
		if (packs > 0)
			e.setCancelled(true);
	}
}
