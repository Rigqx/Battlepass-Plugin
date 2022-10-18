package dk.rigqx.battlepass.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dk.rigqx.battlepass.util.ConfigUtil;
import dk.rigqx.battlepass.util.SkullCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class abonnementMenu {
	Gui gui = Gui.gui().title(Component.text(ConfigUtil.configFile.get("Battlepass.prefix").toString())).rows(4).create();
	private Player p;

	public abonnementMenu(Player p){
		ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		gui.getFiller().fillBottom((ItemBuilder.from(glassPane)).setName("§f").asGuiItem());

		GuiItem guiItem = ItemBuilder.from(Material.BED).setName("§b").setLore("§b§lTILBAGE", "  §8§l・§r §fTryk for at gå tilbage", "").asGuiItem();
		gui.setItem(31, guiItem);

		GuiItem missioner = ItemBuilder.from(SkullCreator.itemFromBase64(ConfigUtil.configFile.get("Battlepass.NBT.abonnement1").toString())).setName("§b").setLore("§b§lABONNEMENT #1", "  §8§l・§r §f14 Dags battlepass..!", "").asGuiItem();
		gui.setItem(10, missioner);

		GuiItem shop = ItemBuilder.from(SkullCreator.itemFromBase64(ConfigUtil.configFile.get("Battlepass.NBT.abonnement2").toString())).setName("§b").setLore("§b§lABONNEMENT #2", "  §8§l・§r §f30 Dags battlepass..!", "  §8§l・§r §f10 Battle coins..!", "").asGuiItem();
		gui.setItem(13, shop);

		GuiItem oversigt = ItemBuilder.from(SkullCreator.itemFromBase64(ConfigUtil.configFile.get("Battlepass.NBT.abonnement3").toString())).setName("§b").setLore("§b§lABONNEMENT #3", "  §8§l・§r §f90 Dags battlepass..!", "  §8§l・§r §f20 Battle coins..!", "").asGuiItem();
		gui.setItem(16, oversigt);

		gui.open(p);

		gui.setDefaultClickAction(event -> {
			event.setCancelled(true);
		});

		gui.addSlotAction(31, event -> {
			new mainGui(p);
		});
	}
}
