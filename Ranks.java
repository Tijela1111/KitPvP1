package me.TijelaPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Ranks implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		sender.sendMessage("§cLegendary");
		sender.sendMessage("§dDestroyer");
		sender.sendMessage("§4Thor");
		sender.sendMessage("§3Advanced");
		sender.sendMessage("§aPrimary");
		return true;
	}

}
