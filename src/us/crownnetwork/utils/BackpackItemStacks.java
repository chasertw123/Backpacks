package us.crownnetwork.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BackpackItemStacks {
	
	public ItemStack compressedStone() {
		ItemStack i = new ItemStack(Material.STONE);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.LIGHT_PURPLE + "Compressed Stone");
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack inactiveBackpack() {
		
		ItemStack i = new ItemStack(Material.CHEST, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1) ");
		List<String> lorelist = new ArrayList<String>();
		lorelist.add("");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Right click with this item in hand to");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "active this backpack.");
		im.setLore(lorelist);
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack leatherBackpack(UUID uuid) {
		
		ItemStack i = new ItemStack(Material.CHEST, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1)");
		List<String> lorelist = new ArrayList<String>();
		lorelist.add("");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "This backpack has 9 slots! Upgrade by surrounding");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "this backpack with compressed stone blocks and a");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "diamond block on the center top slot.");
		lorelist.add("");
		lorelist.add(ChatColor.GRAY + "UUID: " + ChatColor.ITALIC + uuid);
		im.setLore(lorelist);
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack stoneBackpack(UUID uuid) {
		
		ItemStack i = new ItemStack(Material.CHEST, 1);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)");
		List<String> lorelist = new ArrayList<String>();
		lorelist.add("");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "This backpack has 18 slots! Upgrade by surrounding");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "this backpack with iron blocks and a diamond block");
		lorelist.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "on the center top slot.");
		lorelist.add("");
		lorelist.add(ChatColor.GRAY + "UUID: " + ChatColor.ITALIC + uuid);
		im.setLore(lorelist);
		i.setItemMeta(im);
		
		return i;
	}
	
}
