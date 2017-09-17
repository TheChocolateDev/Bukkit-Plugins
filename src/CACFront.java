package me.callmefilms.CAC;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/*
CACFront - Control-All-Complete Main Class
Author: Lucas Eastman
Date: UND

file name: CACFront.java
*/

public class CACFront extends JavaPlugin{
	
	public void onEnable() {
		Bukkit.getServer().getPluginCommand("cac").setExecutor(new Commands());
	}
	
}
