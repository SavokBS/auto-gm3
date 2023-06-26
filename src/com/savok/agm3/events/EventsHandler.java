package com.savok.agm3.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.savok.agm3.Main;

public class EventsHandler implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(!Main.isGm3) return;
		Player p = e.getEntity();
		p.setGameMode(GameMode.SPECTATOR);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (!e.getView().getTitle().equalsIgnoreCase("§l[AGM]")) return;
		e.setCancelled(true);
		Main.isGm3 = !Main.isGm3;
		Player player = (Player) e.getWhoClicked();
		Inventory inv = Bukkit.createInventory(null, 9, "§l[AGM]");
		player.openInventory(inv);
		int s = Main.isGm3 ? 5 : 14;
		String ss = Main.isGm3 ? "§a§lIs auto spectator toggled : true" : "§c§lIs auto spectator toggled : false";
		ItemStack pane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) s);
		ItemMeta panemeta = pane.getItemMeta();
		panemeta.setDisplayName(ss);
		pane.setItemMeta(panemeta);
		inv.setItem(4, pane);
	}
}
