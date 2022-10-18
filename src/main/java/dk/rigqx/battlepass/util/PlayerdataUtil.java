package dk.rigqx.battlepass.util;

import dk.rigqx.battlepass.Battlepass;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerdataUtil {
	public static File file;
	public static FileConfiguration userdataFile;

	public static void setup() {
		file = new File(Battlepass.INSTANCE.getDataFolder(), "userdata.yml");
		if (!file.exists()) {

			try {
				file.createNewFile();
				PlayerdataUtil.get().createSection("userdata");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		userdataFile = YamlConfiguration.loadConfiguration(file);
	}

	public static FileConfiguration get(){
		return userdataFile;
	}

	public static void save() {
		try {
			userdataFile.save(file);
		} catch (IOException e) {
			System.out.println("Couldn't save file..");
		}
	}

	public static void load() {
		userdataFile = YamlConfiguration.loadConfiguration(file);
	}
}
