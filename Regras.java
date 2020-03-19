package me.TijelaPvP.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Regras implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		sender.sendMessage("           §aREGRAS               ");
		sender.sendMessage("aaaa §bNão desrespeite a staff.       ");
		sender.sendMessage(" §bNão use nenhum tipo de trapaça.");
	    sender.sendMessage(" §bNão abuse de bugs.             ");
            return true;
	}

}