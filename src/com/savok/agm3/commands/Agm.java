package com.savok.agm3.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.savok.agm3.Main;

public class Agm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if(arg0 instanceof Player && arg0.hasPermission("agm.agm")) {
		      if(arg1.getName().equalsIgnoreCase("agm")) {
		        if(arg3.length >= 1 && arg3[0].equals("gui")) {
		          Main.isGui = !Main.isGui;
		          arg0.sendMessage("§3[AGM] GUI toggled to " + Main.isGui);
		          if(!Main.isGui) return true;
		        }
		        if(Main.isGui) {
		          Inventory inv = Bukkit.createInventory(null, 9, "§l[AGM]");
		          ((Player)arg0).openInventory(inv);
		          int s = Main.isGm3 ? 5 : 14;
		          String ss = Main.isGm3 ? "§a§lAuto spectator toggled : true" : "§c§lAuto spectator toggled : false";
		          ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) s);
		          ItemMeta panemeta = pane.getItemMeta();
		          panemeta.setDisplayName(ss);
		          pane.setItemMeta(panemeta);
		          inv.setItem(4, pane);
		          return true;
		        }
		        Main.isGm3 = !Main.isGm3;
		        arg0.sendMessage("§3[AGM] Auto spectator toggled to " + Main.isGm3);
		        return true;
		      }
		    }
		    return false;
	}

}
