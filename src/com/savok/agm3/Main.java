package com.savok.agm3;

import org.bukkit.plugin.java.JavaPlugin;

import com.savok.agm3.commands.Agm;
import com.savok.agm3.events.EventsHandler;

public class Main extends JavaPlugin {
	
	public static boolean isGui = false;
	public static boolean isGm3 = false;
	
	@Override
	public void onDisable() { 
	}
	
	@Override
	public void onEnable() { 
		getServer().getPluginManager().registerEvents(new EventsHandler(), this);
		
		getCommand("agm").setExecutor(new Agm());
	}

}
