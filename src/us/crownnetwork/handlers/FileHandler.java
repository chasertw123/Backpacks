package us.crownnetwork.handlers;

import java.io.File;
import java.util.UUID;

import us.crownnetwork.Main;
import us.crownnetwork.utils.Yaml;

public class FileHandler {

	Main plugin;
	
	public FileHandler(Main plugin) {
		this.plugin = plugin;
	}
	
	public Yaml getBackpack(UUID uuid) {
	 return new Yaml(plugin.getDataFolder().getAbsolutePath() + File.separator + "backpacks" 
			 + File.separator + uuid + ".yml");
	}
	
}
