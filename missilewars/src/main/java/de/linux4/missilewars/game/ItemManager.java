/*******************************************************************************
 * Copyright (C) 2019 Linux4
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package de.linux4.missilewars.game;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.linux4.missilewars.game.Game.PlayerTeam;

public class ItemManager implements Runnable {

	private ItemStack[] items;
	private Game game;
	private static final ThreadLocalRandom random = ThreadLocalRandom.current();

	public ItemManager(Game game) {
		this.game = game;
		ItemStack arrow = new ItemStack(Material.ARROW, 3);
		ItemMeta arrowMeta = arrow.getItemMeta();
		arrowMeta.setDisplayName("§eArrow");
		arrow.setItemMeta(arrowMeta);
		items = new ItemStack[] { arrow, game.fireball, game.tomahawk, game.juggernaut, game.shieldBuster,
				game.guardian, game.lightning, game.shield };
	}

	@Override
	public void run() {
		final int i = random.nextInt(items.length);
		ItemStack item = items[i];
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (game.getPlayerTeam(player) == PlayerTeam.GREEN
					|| game.getPlayerTeam(player) == PlayerTeam.RED) {
				if (!player.getInventory().contains(item)) {
					player.getInventory().addItem(item);
				}
			}
		}
	}

	public void dEquip(Player player, int a) {
		for (ItemStack item : items) {
			ItemStack tmp = item.clone();
			tmp.setAmount(a);
			player.getInventory().addItem(tmp);
		}
	}

}
