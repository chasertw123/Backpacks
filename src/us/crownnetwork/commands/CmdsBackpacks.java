package us.crownnetwork.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import us.crownnetwork.Main;

public class CmdsBackpacks implements CommandExecutor {

	private Main plugin;
	
	public CmdsBackpacks(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!cmd.getName().equalsIgnoreCase("backpack") || !cmd.getName().equalsIgnoreCase("bp"))
			return true;
		
		if (args.length == 0) {
			
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				plugin.sendMessage(p, ChatColor.RED + "Try using " + ChatColor.WHITE + "/bp help " + ChatColor.RED + "for help!");
			} else plugin.sendConsole("Try using /bp help for help!");
			
		} else if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("help")) {
				
				if (sender instanceof Player) {
					
					Player p = (Player) sender;
					
					if (!p.hasPermission("backpacks.help")) {
						p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
						return true;
					}
					
					p.openInventory(this.helpMenu());
				
				} else {
					
					// Send Big Block Of Text
				}
			}
			
		} else {
			
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				plugin.sendMessage(p, ChatColor.RED + "Try using " + ChatColor.WHITE + "/bp help " + ChatColor.RED + "for help!");
			} else plugin.sendConsole("Try using /bp help for help!");
		}
		return false;
	}

	private Inventory helpMenu() {
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "" + ChatColor.UNDERLINE + "Help Menu");
		
		inv.setItem(0, this.help());
		
		return inv;
	}
	
	private ItemStack help() {
		ItemStack i = new ItemStack(Material.BEACON);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "/bp help");
		List<String> lorelist = new ArrayList<String>();
		lorelist.add(ChatColor.WHITE + "" + ChatColor.ITALIC + "");
		lorelist.add(ChatColor.WHITE + "" + ChatColor.ITALIC + "");
		im.setLore(lorelist);
		i.setItemMeta(im);
		
		return i;
	}
	
}
