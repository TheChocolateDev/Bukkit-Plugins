package me.callmefilms.CAC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands<T> implements CommandExecutor{

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sndr, Command cmd, String label, String[] args) {
		if(!(sndr instanceof Player)) {
			sndr.sendMessage("Sorry, but this command can not be execute by console personnel. Please try again in-game.");
		} else {
			Player player = (Player) sndr;
			String cacPrefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Cntrl" + ChatColor.GOLD + "All" + ChatColor.YELLOW + "Complete" + ChatColor.GRAY + "] ";
			if(cmd.getName().equalsIgnoreCase("cac")) {
				if(player.hasPermission("cac.command.cac")) {
					if(args.length < 1) {
						sendHelp(player);
					} else {
						switch(args[0]) {
						case "setgm":
							if(player.hasPermission("cac.command.setgm")) {
								if(args.length < 2) {
									player.sendMessage(displayUsage("setgm"));
								} else {
									switch(args[1]) {
									case "0":
										for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
											targetPlayer.setGameMode(GameMode.SURVIVAL);
											targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "Your " + ChatColor.GOLD + "gamemode " + ChatColor.YELLOW + "has been set to " + ChatColor.GOLD + "survival" + ChatColor.GOLD + ".");
										}
										break;
									case "1":
										for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
											targetPlayer.setGameMode(GameMode.CREATIVE);
											targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "Your " + ChatColor.GOLD + "gamemode " + ChatColor.YELLOW + "has been set to " + ChatColor.GOLD + "creative" + ChatColor.GOLD + ".");
										}
										break;
									case "2":
										for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
											targetPlayer.setGameMode(GameMode.ADVENTURE);
											targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "Your " + ChatColor.GOLD + "gamemode " + ChatColor.YELLOW + "has been set to " + ChatColor.GOLD + "adventure" + ChatColor.GOLD + ".");
										}
										break;
									case "3":
										for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
											targetPlayer.setGameMode(GameMode.SPECTATOR);
											targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "Your " + ChatColor.GOLD + "gamemode " + ChatColor.YELLOW + "has been set to " + ChatColor.GOLD + "spectator" + ChatColor.GOLD + ".");
										}
										break;
									default:
										player.sendMessage(cacPrefix + ChatColor.GOLD + "Set GM List:");
										player.sendMessage(ChatColor.GOLD + "0 " + ChatColor.YELLOW + "- " + ChatColor.GOLD + "Survival");
										player.sendMessage(ChatColor.GOLD + "1 " + ChatColor.YELLOW + "- " + ChatColor.GOLD + "Creative");
										player.sendMessage(ChatColor.GOLD + "2 " + ChatColor.YELLOW + "- " + ChatColor.GOLD + "Adventure");
										player.sendMessage(ChatColor.GOLD + "3 " + ChatColor.YELLOW + "- " + ChatColor.GOLD + "Spectator");
										break;
									}
								}
							} else {
								player.sendMessage(cacPrefix + ChatColor.GOLD + "Sorry" + ChatColor.YELLOW + ", but you don't have " + ChatColor.GOLD + "permission " + ChatColor.YELLOW + "to do that.");
							}
							break;
						case "clear":
							if(player.hasPermission("cac.command.clear")) {
								for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
									if(!targetPlayer.hasPermission("cac.exempt.clear")) {
										targetPlayer.getInventory().clear();
										targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "Your inventory has been " + ChatColor.GOLD + "cleared" + ChatColor.YELLOW + ".");
										}
								}
							} else {
								player.sendMessage(cacPrefix + ChatColor.GOLD + "Sorry" + ChatColor.YELLOW + ", but you don't have " + ChatColor.GOLD + "permission " + ChatColor.YELLOW + "to do that.");
							}
							break;
						case "setfly":
							if(player.hasPermission("cac.command.setfly")) {
								if(args.length < 2) {
									player.sendMessage(displayUsage("setfly"));
								} else {
									for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
										if(!targetPlayer.hasPermission("cac.exempt.setfly")) {
											switch(args[1]) {
											case "on":
												if(!targetPlayer.getAllowFlight()) {
													targetPlayer.setAllowFlight(true);
													targetPlayer.setFlying(true);
													targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "You've been put into " + ChatColor.GOLD + "fly " + ChatColor.YELLOW + "mode.");
												}
												break;
											case "off":
												if(targetPlayer.getAllowFlight()) {
													targetPlayer.setFlying(false);
													targetPlayer.setAllowFlight(false);
													targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "You've been taken out of " + ChatColor.GOLD + "fly " + ChatColor.YELLOW + "mode.");
												}
												break;
											default:
												player.sendMessage(displayUsage("setfly"));
											}
										}
									}
								}
							} else {
								player.sendMessage(cacPrefix + ChatColor.GOLD + "Sorry" + ChatColor.YELLOW + ", but you don't have " + ChatColor.GOLD + "permission " + ChatColor.YELLOW + "to do that.");
							}
							break;
						case "msgall":
							if(player.hasPermission("cac.command.msgall")) {
								if(args.length < 2) {
									player.sendMessage(displayUsage("msgall"));
								} else {
									String msg = args[1];
									for(int i = 2; i < args.length; i++) {
										msg = msg + " " + args[i];
									}
									for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
										targetPlayer.sendMessage(ChatColor.GRAY + "[" + ChatColor.YELLOW + "C" + ChatColor.GOLD + "A" + ChatColor.YELLOW + "C" + ChatColor.GRAY + "] " + ChatColor.WHITE + "[" + ChatColor.YELLOW + player.getDisplayName() + " " + ChatColor.GOLD + "--> " + ChatColor.YELLOW + "You" + ChatColor.WHITE + "] " + ChatColor.GOLD + msg);
									}
								}
							} else {
								player.sendMessage(cacPrefix + ChatColor.GOLD + "Sorry" + ChatColor.YELLOW + ", but you don't have " + ChatColor.GOLD + "permission " + ChatColor.YELLOW + "to do that.");
							}
							break;
						case "teleportall":
							if(player.hasPermission("cac.command.teleportall")) {
								if(args.length < 2) {
									player.sendMessage(displayUsage("teleportall"));
								} else {
									switch(args[1]) {
									case "Server":
										for(Player targetPlayer : Bukkit.getServer().getOnlinePlayers()) {
											targetPlayer.teleport(teleport);
											targetPlayer.sendMessage(cacPrefix + ChatColor.YELLOW + "You " + ChatColor.GOLD + "have " + ChatColor.YELLOW + "been teleported. ";
									    break;
			              default:
							sendHelp(player);
						}
					}
				}
			}
		}
		return false;
	}
	
	static public String displayUsage(String command) {
		String cacPrefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Cntrl" + ChatColor.GOLD + "All" + ChatColor.YELLOW + "Complete" + ChatColor.GRAY + "] ";
		String usage = cacPrefix + ChatColor.GOLD + "Correct usage: ";
		switch(command) {
		case "setgm":
			usage = usage + ChatColor.YELLOW + "/cac setgm <gamemode>";
			break;
		case "setfly":
			usage = usage + ChatColor.YELLOW + "/cac setfly <on|off>";
			break;
		case "msgall":
			usage = usage + ChatColor.YELLOW + "/cac msgall <message>";
		case "teleportall"
		    usage = usage + ChatColor.YELLOW + "/cac teleportall <x> <y> <z> [<y-rot> <x-rot>]";
			break;
		default:
			String error = cacPrefix + ChatColor.RED + "Error: " + ChatColor.DARK_RED + "Usage missing from system. Please contact " + ChatColor.RED + "CallMeBlind or Mr_coolman " + ChatColor.DARK_RED + "on the plugin dev site.";
			return error;
		}
		return usage;
	}
	
	static public void sendHelp(Player player) {
		String cacPrefix = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Cntrl" + ChatColor.GOLD + "All" + ChatColor.YELLOW + "Complete" + ChatColor.GRAY + "] ";
		String helpHeader = cacPrefix + ChatColor.YELLOW + "C" + ChatColor.GOLD + "A" + ChatColor.YELLOW + "C " + ChatColor.GOLD + "Help Menu:";
		String helpGM = ChatColor.GOLD + "/cac setgm: " + ChatColor.YELLOW + "Set the global gamemode for all players at the same time.";
		String helpFly = ChatColor.GOLD + "/cac setfly: " + ChatColor.YELLOW + "Put all players in our out of fly mode at the same time.";
		String helpMSG = ChatColor.GOLD + "/cac msgall: " + ChatColor.YELLOW + "Msg all players at the same time.";
		String helpTA = ChatColor.GOLD + "/cac teleport all" + ChatColor.YELLOW + "Teleport the whole server to a location," + ChatColor.RED + "Warning, Teleporting lots of people does get very laggy.";
		String[] helpList = {helpHeader, helpGM, helpFly, helpMSG, helpTA};
		for(String helpIndex : helpList) {
			player.sendMessage(helpIndex);
		}
	}
	
}
