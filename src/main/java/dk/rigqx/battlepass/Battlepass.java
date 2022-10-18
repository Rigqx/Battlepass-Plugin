package dk.rigqx.battlepass;

import dk.rigqx.battlepass.command.BattlepassCommand;
import dk.rigqx.battlepass.listener.ConnectionListener;
import dk.rigqx.battlepass.listener.MissionListener;
import dk.rigqx.battlepass.listener.NPCListener;
import dk.rigqx.battlepass.util.ConfigUtil;
import dk.rigqx.battlepass.util.PlayerdataUtil;
import lombok.NonNull;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.plugin.java.JavaPlugin;

public final class Battlepass extends JavaPlugin {
	public static Battlepass INSTANCE;

	@Override
	public void onEnable() {
		INSTANCE = this;

		getCommand("battlepass").setExecutor(new BattlepassCommand());

		getServer().getPluginManager().registerEvents(new MissionListener(this), this);
		getServer().getPluginManager().registerEvents(new ConnectionListener(this), this);
		getServer().getPluginManager().registerEvents(new NPCListener(this), this);

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();

		PlayerdataUtil.setup();
		PlayerdataUtil.save();

		ConfigUtil.setup();
		ConfigUtil.get().addDefault("Battlepass.prefix", "§8§l・§r §b§lBATTLEPASS §8§l・§r");
		ConfigUtil.get().addDefault("Battlepass.ncpID", 0);
		ConfigUtil.get().addDefault("Battlepass.NBT.mission", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODQ0NDk4YTBmZTI3ODk1NmUzZDA0MTM1ZWY0YjEzNDNkMDU0OGE3ZTIwOGM2MWIxZmI2ZjNiNGRiYzI0MGRhOCJ9fX0=");
		ConfigUtil.get().addDefault("Battlepass.NBT.shop", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWUyNWRiZTQ3NjY3ZDBjZTIzMWJhYTIyM2RlZTk1M2JiZmM5Njk2MDk3Mjc5ZDcyMzcwM2QyY2MzMzk3NjQ5ZSJ9fX0=");
		ConfigUtil.get().addDefault("Battlepass.NBT.oversigt", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGY1M2ViODA2ODQwMDcwNTg1Y2NhZWRlZjViMjNkMDIxNjRjNmQyYjhlNjQzODE0NGVhZmY4MWJiNWM2ZjZjMyJ9fX0=");

		ConfigUtil.get().addDefault("Battlepass.NBT.abonnement1", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzFhNzg1OTE2ZDJkMTdjYTBlYTJhZDIzZDgwMjQ3YzdjNTAyMTQ0MzkwM2JiYWI3YjI0Yjc5MzRiNmEzNjFhYiJ9fX0=");
		ConfigUtil.get().addDefault("Battlepass.NBT.abonnement2", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDJjM2Q3MzE3NzA3OTdlMTdhYmNiMTRhZTBmYzlkOWUwNjhkZWI3NDlkZGRiOTI1MDFjMGY2MTQ1NzY5ZTI1YyJ9fX0=");
		ConfigUtil.get().addDefault("Battlepass.NBT.abonnement3", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGJmYzdmYTRlNzRiNmU0MDFhZTA2NDE0OGFlNWU3NjhiODkzZjFkOTI5N2Y4NzQ3NTEwMWY3MjI1YTJhNWE2YSJ9fX0=");
		ConfigUtil.get().options().copyDefaults(true);
		ConfigUtil.save();
	}

	@Override
	public void onDisable() {
		ConfigUtil.save();
	}
}
