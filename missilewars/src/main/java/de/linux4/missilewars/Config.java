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
package de.linux4.missilewars;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private int maxPlayers;
	private boolean keepInventory;
	private int itemCap;
	private int resupplyTimer;
	private boolean enableFireworks;
	private boolean enableAnimatedExplosions;
	private int startCountdown;
	private int endCountdown;

	public Config(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
		maxPlayers = conf.getInt("max-players", 24);
		keepInventory = conf.getBoolean("keepinventory", true);
		itemCap = conf.getInt("item-cap", 1);
		resupplyTimer = conf.getInt("resupply-timer", 11);
		enableFireworks = conf.getBoolean("enable-fireworks", true);
		enableAnimatedExplosions = conf.getBoolean("enable-animated-explosions", true);
		startCountdown = conf.getInt("start-countdown", 60);
		endCountdown = conf.getInt("end-countdown", 30);

		if (maxPlayers % 2 != 0 || maxPlayers <= 0) {
			throw new IllegalArgumentException("max-players should be an even number > 0");
		}

		if (resupplyTimer == 0) {
			throw new IllegalArgumentException("resupply-timer should be > 0");
		}

		if (itemCap < 0) {
			throw new IllegalArgumentException("item-cap should be >= 0");
		}
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public boolean isKeepInventory() {
		return keepInventory;
	}

	public int getItemCap() {
		return itemCap;
	}

	public int getResupplyTimer() {
		return resupplyTimer;
	}

	public boolean enableFireworks() {
		return enableFireworks;
	}

	public boolean enableAnimatedExplosions() {
		return enableAnimatedExplosions;
	}

	public int getStartCountdown() {
		return startCountdown;
	}

	public int getEndCountdown() {
		return endCountdown;
	}
}
