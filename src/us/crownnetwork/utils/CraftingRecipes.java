package us.crownnetwork.utils;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

import us.crownnetwork.Main;

public class CraftingRecipes {
	
	private Main plugin;
	
	public CraftingRecipes(Main plugin) {
		this.plugin = plugin;
	}
	
	public void init() {
		
		BackpackItemStacks backpacks = new BackpackItemStacks();
		
		ShapedRecipe leatherBackpack = new ShapedRecipe(backpacks.inactiveBackpack());
		leatherBackpack.shape("@#@", "$%$", "@@@");
		leatherBackpack.setIngredient('@', Material.LEATHER);
		leatherBackpack.setIngredient('#', Material.DIAMOND);
		leatherBackpack.setIngredient('$', Material.IRON_INGOT);
		leatherBackpack.setIngredient('%', Material.CHEST);
		
		ShapedRecipe compressedStone = new ShapedRecipe(backpacks.compressedStone());
		compressedStone.shape("@@@", "@#@", "@@@");
		compressedStone.setIngredient('@', Material.STONE);
		compressedStone.setIngredient('#', Material.IRON_INGOT);
		
		ShapedRecipe stoneBackpack = new ShapedRecipe(backpacks.stoneBackpack(UUID.randomUUID()));
		stoneBackpack.shape("@#@", "@$@", "@@@");
		stoneBackpack.setIngredient('@', Material.STONE);
		stoneBackpack.setIngredient('$', Material.CHEST);
		stoneBackpack.setIngredient('#', Material.DIAMOND_BLOCK);
		
		plugin.getServer().addRecipe(leatherBackpack);
		plugin.getServer().addRecipe(compressedStone);
		plugin.getServer().addRecipe(stoneBackpack);
	}

}
