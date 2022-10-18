package dk.rigqx.battlepass.listener;

import dk.rigqx.battlepass.Battlepass;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MissionListener implements Listener {
    private final Battlepass battlepass;
    public MissionListener(Battlepass battlepass) {
        this.battlepass = battlepass;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Audience audience = this.battlepass.adventure().player(event.getPlayer());

        BossBar bar = BossBar.bossBar(Component.text("Test Bossbar"), 0.5f, BossBar.Color.YELLOW, BossBar.Overlay.NOTCHED_12);

        audience.showBossBar(bar);
    }


}
