package dk.rigqx.battlepass.command;

import dk.rigqx.battlepass.util.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class BattlepassCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;

		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("reload")){
				ConfigUtil.load();
				p.sendMessage("§aGenindlæste Battlepass..!");
				return true;
			} else if(args[0].equalsIgnoreCase("givPass")){
				if (args.length >= 1) {

				} else {
					p.sendMessage("§cKommandoer: §a/Battlepass givPass Plan Spiller");
				}
			} else if(args[0].equalsIgnoreCase("fjernPass")){
				if (args.length >= 1) {

				} else {
					p.sendMessage("§cKommandoer: §a/Battlepass fjernPass Spiller");
				}
			}
		} else {
			p.sendMessage("§cKommandoer: §a/Battlepass §8(§fReload§7/§fgivPass§7/§ffjernPass§8)");
		}

		return true;
	}
}
