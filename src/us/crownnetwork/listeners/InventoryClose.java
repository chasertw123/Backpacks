package us.crownnetwork.listeners;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import us.crownnetwork.Main;
import us.crownnetwork.utils.Yaml;

public class InventoryClose implements Listener {

	private Main plugin;
	
	public InventoryClose(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		
		if (!(e.getPlayer() instanceof Player))
			return;
			
		Player p = (Player) e.getPlayer();
          
		if (e.getInventory().getName().equals(ChatColor.GRAY + "" + ChatColor.UNDERLINE + "Backpack")) {
			
			char c = 'a';
			Yaml yaml = plugin.getFh().getBackpack(UUID.fromString(ChatColor.stripColor(p.getItemInHand().getItemMeta().getLore().get(5)).substring(6)));
			
			for (ItemStack i : e.getInventory().getContents())
				if (i != null)
					this.saveItem(yaml.createSection("backpack.contents." + c++), i);
			
			yaml.save();
		}
		
	}
	
	private void saveItem(ConfigurationSection section, ItemStack itemStack) {
        section.set("type", itemStack.getType().name());
        section.set("data", itemStack.getDurability());
        section.set("amount", itemStack.getAmount());
        // Save more information.
	}
}
