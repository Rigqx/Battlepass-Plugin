package dk.rigqx.battlepass.gui;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dk.rigqx.battlepass.util.ConfigUtil;
import dk.rigqx.battlepass.util.ItemStackBuilder;
import dk.rigqx.battlepass.util.PlayerdataUtil;
import dk.rigqx.battlepass.util.SkullCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class mainGui {

	Gui gui = Gui.gui().title(Component.text(ConfigUtil.configFile.get("Battlepass.prefix").toString())).rows(4).create();
	private Player p;

	public mainGui(Player p){
		final UUID uuid = p.getUniqueId();

		ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
		gui.getFiller().fillBottom((ItemBuilder.from(glassPane)).setName("§f").asGuiItem());

		ItemStack skull = new ItemStackBuilder()
				.withName("§f")
				.withLore("§f")
				.toSkullBuilder().withOwner(p.getPlayer().getName())
				.buildSkull();

		GuiItem guiItem = ItemBuilder.from(skull).setName("§b").setLore("§b§lBRUGER INFO", "  §8§l・§r §fBruger: §b" + p.getDisplayName(), "  §8§l・§r §fAbonnement: §b" + (PlayerdataUtil.get().getString("userdata." + uuid + ".abonnement").replace("false", "§cInaktiv").replace("true", "§aAktiv")), "  §8§l・§r §fBattle Coins: §b" + PlayerdataUtil.get().getInt("userdata." + uuid + ".battlecoins"), "").asGuiItem();
		gui.setItem(31, guiItem);

		GuiItem missioner = ItemBuilder.from(SkullCreator.itemFromBase64(ConfigUtil.configFile.get("Battlepass.NBT.mission").toString())).setName("§b").setLore("§b§lMISSIONER", "  §8§l・§r §fTryk for at se dine tilgængelige missioner..!", "").asGuiItem();
		gui.setItem(10, missioner);

		GuiItem shop = ItemBuilder.from(SkullCreator.itemFromBase64(ConfigUtil.configFile.get("Battlepass.NBT.shop").toString())).setName("§b").setLore("§b§lSHOP", "  §8§l・§r §fTryk for at se shoppen..!", "").asGuiItem();
		gui.setItem(13, shop);

		GuiItem oversigt = ItemBuilder.from(SkullCreator.itemFromBase64(ConfigUtil.configFile.get("Battlepass.NBT.oversigt").toString())).setName("§b").setLore("§b§lOVERSIGT", "  §8§l・§r §fTryk for at se alle abonnementer..!", "").asGuiItem();
		gui.setItem(16, oversigt);


		gui.open(p);

		gui.setDefaultClickAction(event -> {
			event.setCancelled(true);
		});

		gui.addSlotAction(16, event -> {
			new abonnementMenu(p);
		});
		gui.addSlotAction(13, event -> {
			new shopMenu(p);
		});
		gui.addSlotAction(10, event -> {
			new missionerMenu(p);
		});
	}

}
