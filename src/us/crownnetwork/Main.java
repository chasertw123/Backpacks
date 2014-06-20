package us.crownnetwork;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import us.crownnetwork.handlers.FileHandler;
import us.crownnetwork.handlers.ListenerHandler;
import us.crownnetwork.utils.CraftingRecipes;

public class Main extends JavaPlugin {
	
	/* TODOs
	 * 
	 * Add dynamic inventory sizes per player
	 * More Permissions
	 * More Commands
	 * 
	 */
	
	/** Classes **/
	private FileHandler fh = new FileHandler(this);
	
	/** HashMaps **/
	private HashMap<UUID, Inventory> backpacks = new HashMap<UUID, Inventory>();
	
	public void onEnable() {
		
		new ListenerHandler(this).init();
		new CraftingRecipes(this).init();
		
	}
	
	public void onDisable() {
		
		/*
		for (Entry<UUID, Inventory> entry : backpacks.entrySet()) {
            if (!this.getFh().contains("backpacks." + entry.getKey())) {
            	this.getFh().createSection("backpacks." + entry.getKey());
            }
           
            char c = 'a';
            for (ItemStack itemStack : entry.getValue()) {
                    if (itemStack != null)
                            this.getFh().saveItem(this.getFh().createSection("backpacks." + entry.getKey() + "." + c++), itemStack);
            }
           
            this.getFh().save();
		}
		*/
	}

	/************************************************
	 * 												*
	 *					Messages					*
	 * 												*
	 ************************************************/
	
	String prefix = ChatColor.WHITE + "[" + ChatColor.AQUA + "" 
			+ ChatColor.ITALIC + "Backpacks" + ChatColor.WHITE + "] "; 
	
	public void sendMessage(Player p, String message) {
		p.sendMessage(prefix + message);
	}
	
	public void sendConsole(String message) {
		this.getLogger().info(ChatColor.stripColor(prefix) + message);
	}

	/************************************************
	 * 												*
	 *				Getters and Setters				*
	 * 												*
	 ************************************************/

	public HashMap<UUID, Inventory> getBackpacks() {
		return backpacks;
	}

	public void setBackpacks(HashMap<UUID, Inventory> backpacks) {
		this.backpacks = backpacks;
	}

	public FileHandler getFh() {
		return fh;
	}

	public void setFh(FileHandler fh) {
		this.fh = fh;
	}
	
}
