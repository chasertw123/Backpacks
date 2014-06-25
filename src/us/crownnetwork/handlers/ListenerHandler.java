package us.crownnetwork.handlers;

import org.bukkit.plugin.PluginManager;

import us.crownnetwork.Main;
import us.crownnetwork.listeners.BlockPlace;
import us.crownnetwork.listeners.InventoryClick;
import us.crownnetwork.listeners.InventoryClose;
import us.crownnetwork.listeners.PlayerInteract;
import us.crownnetwork.listeners.PlayerPickupItem;
import us.crownnetwork.listeners.PrepareItemCraft;

public class ListenerHandler {

	private Main plugin;
	
	public ListenerHandler(Main plugin) {
		this.plugin = plugin;
	}
	
	public void init() {
		PluginManager pm = plugin.getServer().getPluginManager();
		pm.registerEvents(new PrepareItemCraft(), plugin);
		pm.registerEvents(new BlockPlace(plugin), plugin);
		pm.registerEvents(new InventoryClick(plugin), plugin);
		pm.registerEvents(new PlayerPickupItem(), plugin);
		pm.registerEvents(new PlayerInteract(plugin), plugin);
		pm.registerEvents(new InventoryClose(plugin), plugin);
	}
}
