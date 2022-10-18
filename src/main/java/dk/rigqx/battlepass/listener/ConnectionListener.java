package dk.rigqx.battlepass.listener;

import dk.rigqx.battlepass.Battlepass;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {
	private final Battlepass battlepass;


	public ConnectionListener(Battlepass battlepass) {
		this.battlepass = battlepass;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){}
}
