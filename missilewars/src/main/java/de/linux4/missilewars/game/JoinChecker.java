/*******************************************************************************
 * Copyright (C) 2019-2020 Linux4
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

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class JoinChecker implements Runnable {

	private Game game;

	public JoinChecker(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			Location loc = player.getLocation();
			loc = new Location(loc.getWorld(), (int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), 0, 0);
			if (game.getGreenJoin().contains(loc)) {
				game.greenAddPlayer(player);
			} else if (game.getRedJoin().contains(loc)) {
				game.redAddPlayer(player);
			}
		}
	}

}
