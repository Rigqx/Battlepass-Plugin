package dk.rigqx.battlepass.listener;

import dk.rigqx.battlepass.Battlepass;
import dk.rigqx.battlepass.gui.mainGui;
import dk.rigqx.battlepass.util.ConfigUtil;
import dk.rigqx.battlepass.util.PlayerdataUtil;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class NPCListener implements Listener {
	private final Battlepass battlepass;

	public NPCListener(Battlepass battlepass) {
		this.battlepass = battlepass;
	}

	@EventHandler
	public void onNPCClick(PlayerInteractEntityEvent event) {
		if (event.getRightClicked() != null && event.getRightClicked().hasMetadata("NPC")) {
			int id = (CitizensAPI.getNPCRegistry().getNPC(event.getRightClicked()) != null) ? CitizensAPI.getNPCRegistry().getNPC(event.getRightClicked()).getId() : null;
			if (ConfigUtil.get().get("Battlepass.ncpID").equals(id)) {
				final UUID uuid = event.getPlayer().getUniqueId();

				ConfigurationSection section = PlayerdataUtil.get().getConfigurationSection("userdata." + uuid.toString());

				if (section == null) {
					section = PlayerdataUtil.get().createSection("userdata." + uuid.toString());

					PlayerdataUtil.get().set("userdata." + uuid.toString() + ".abonnement", false);
					PlayerdataUtil.get().set("userdata." + uuid.toString() + ".boughtAt", null);
					PlayerdataUtil.get().set("userdata." + uuid.toString() + ".plan", null);
					PlayerdataUtil.get().set("userdata." + uuid.toString() + ".battlecoins", 0);

				} else {
					PlayerdataUtil.load();
				}

				PlayerdataUtil.save();

				new mainGui(event.getPlayer());
			}
		}
	}
}
