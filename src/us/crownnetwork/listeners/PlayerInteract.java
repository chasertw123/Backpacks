package us.crownnetwork.listeners;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.crownnetwork.Main;
import us.crownnetwork.utils.BackpackItemStacks;
import us.crownnetwork.utils.Yaml;

public class PlayerInteract implements Listener {

	private Main plugin;

	public PlayerInteract(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (p.getItemInHand() == null || !p.getItemInHand().hasItemMeta())
				return;

			ItemStack i = p.getItemInHand();

			plugin.sendConsole(i.getItemMeta().getLore().size() + "");

			if (i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1) ")
					&& i.getItemMeta().getLore().size() == 3) {
				
				int packs = 0;

				for (ItemStack i1 : p.getInventory().getContents()) {

					if (i1 == null || !i1.hasItemMeta())
						continue;

					String name = i1.getItemMeta().getDisplayName();

					if (name.equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1)")
							|| name.equals(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)"))
						packs++;
				}

				if (packs >= 1)
					plugin.sendMessage(p, ChatColor.RED + "You can't have any other backpacks "
									+ "in your inventory when you activate a new backpack.");

				UUID uuid = UUID.randomUUID();
				Yaml yaml = plugin.getFh().getBackpack(uuid);

				p.getInventory().addItem(new BackpackItemStacks().leatherBackpack(uuid));
				p.getInventory().remove(i);
				p.updateInventory();

				yaml.set("backpack.size", 9);
				yaml.save();

				plugin.sendMessage(p, ChatColor.GREEN + "You just activated a leather backpack!");
			}

			if (i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Leather Backpack" + ChatColor.GRAY + " (Tier 1)")
					|| i.getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA + "Stone Backpack" + ChatColor.GRAY + " (Tier 2)")) {
				
				Yaml yaml = plugin.getFh().getBackpack(UUID.fromString(ChatColor.stripColor(p.getItemInHand().getItemMeta().getLore().get(5)).substring(6)));
				Inventory inv = Bukkit.createInventory(null, yaml.getInteger("backpack.size"), ChatColor.GRAY + "" + ChatColor.UNDERLINE + "Backpack");
				
				if (yaml.contains("backpack.contents"))
					for (String item : yaml.getConfigurationSection("backpack.contents").getKeys(false))
						inv.addItem(loadItem(yaml.getConfigurationSection("backpack.contents" + item)));
                     
                p.openInventory(inv);
			}

		}
	}
	

	private ItemStack loadItem(ConfigurationSection section) {
        return new ItemStack(Material.valueOf(section.getString("type")), section.getInt("amount"), (short) section.getDouble("data"));
        // Load more information.
	}
}
