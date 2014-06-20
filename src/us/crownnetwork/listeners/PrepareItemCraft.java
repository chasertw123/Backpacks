package us.crownnetwork.listeners;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import us.crownnetwork.utils.BackpackItemStacks;

public class PrepareItemCraft implements Listener {
	
	@EventHandler
	public void onPrepareItemCraft(PrepareItemCraftEvent e) {
		
		if (e.getView().getType() != InventoryType.WORKBENCH)
			return;
		
		CraftingInventory ci = e.getInventory();
		
		if (ci.getResult().hasItemMeta() && ci.getResult().getItemMeta().getDisplayName()
				.equals(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)")) {
			
			boolean chest = false;
			int stone = 0;
			
			UUID uuid = null;
			
			for (ItemStack i : ci.getMatrix()) {
				if (i != null && i.hasItemMeta() && i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA 
						+ "Leather Backpack" + ChatColor.GRAY + " (Tier 1)")) {
					chest = true;
					uuid = UUID.fromString(i.getItemMeta().getLore().get(6).substring(6));
				}
				
				if (i != null && i.hasItemMeta() && i.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Compressed Stone"))
					stone++;
			}
			
			if (chest == false || stone < 7)
				ci.setResult(null);
			else ci.setResult(new BackpackItemStacks().stoneBackpack(uuid));
		}
		
		else if (ci.getResult().hasItemMeta() && ci.getResult().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA 
						+ "Leather Backpack" + ChatColor.GRAY + " (Tier 1)")) {
			
			ci.setResult(new BackpackItemStacks().inactiveBackpack());
		}
		
	}
	
}
