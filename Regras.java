package me.TijelaPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Regras implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		sender.sendMessage("           �aREGRAS               ");
		sender.sendMessage("aaaa �bN�o desrespeite a staff.       ");
		sender.sendMessage(" �bN�o use nenhum tipo de trapa�a.");
	    sender.sendMessage(" �bN�o abuse de bugs.             ");
            return true;
	}

}