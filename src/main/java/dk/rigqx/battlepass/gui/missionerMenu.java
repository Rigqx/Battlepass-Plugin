package dk.rigqx.battlepass.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dk.rigqx.battlepass.util.ConfigUtil;
import dk.rigqx.battlepass.util.PlayerdataUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class missionerMenu {
	Gui gui = Gui.gui().title(Component.text(ConfigUtil.configFile.get("Battlepass.prefix").toString())).rows(4).create();
	private Player p;

	public missionerMenu(Player p){
		ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		gui.getFiller().fillBottom((ItemBuilder.from(glassPane)).setName("§f").asGuiItem());

		GuiItem guiItem = ItemBuilder.from(Material.BED).setName("§b").setLore("§b§lTILBAGE", "  §8§l・§r §fTryk for at gå tilbage", "").asGuiItem();
		gui.setItem(31, guiItem);

		if(!PlayerdataUtil.get().getBoolean("userdata." + p.getUniqueId() + ".abonnement")){
			GuiItem nejTak = ItemBuilder.from(Material.BARRIER).setName("§b").setLore("§4§lINGEN ADGANG", "  §8§l・§r §fDu ejer ikke gyldigt Battlepass Abonnement.", "").asGuiItem();
			gui.setItem(13, nejTak);
		}

		gui.open(p);

		gui.setDefaultClickAction(event -> {
			event.setCancelled(true);
		});

		gui.addSlotAction(31, event -> {
			new mainGui(p);
		});
	}
}
