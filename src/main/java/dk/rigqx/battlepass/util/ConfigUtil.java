package dk.rigqx.battlepass.util;

import dk.rigqx.battlepass.Battlepass;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.*;

import java.io.*;

public class ConfigUtil {
	public static File file;
	public static FileConfiguration configFile;

	public static void setup() {
		file = new File(Battlepass.INSTANCE.getDataFolder(), "config.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		configFile = YamlConfiguration.loadConfiguration(file);
	}

	public static FileConfiguration get(){
		return configFile;
	}

	public static void save() {
		try {
			configFile.save(file);
		} catch (IOException e) {
			System.out.println("Couldn't save file..");
		}
	}

	public static void load() {
		configFile = YamlConfiguration.loadConfiguration(file);
	}
}
