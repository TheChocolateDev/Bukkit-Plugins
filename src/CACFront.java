package me.callmefilms.CAC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CACFront extends JavaPlugin{
	
//	Look at this Coolman
//	We can talk in here :D
	/*
	 * Coolman: fine
	 * we should make another plugin, already got a good idea
	 * a plugin that takes ranks and puts them in game-a-tags
	 * ok
	 * i already sent it to you
	 * 
	 
	 * 
	 * Blind:
	 * Oh ok
	 * That's ok
	 * We can share it a lot of ways
	 * We don't need Eclipse
	 * 
	 */
	
	public void onEnable() {
		Bukkit.getServer().getPluginCommand("cac").setExecutor(new Commands());
	}
	
}
