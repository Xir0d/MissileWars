/*******************************************************************************
 * Copyright (C) 2020 Linux4
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

import org.bukkit.Bukkit;

public enum BukkitVersion {
	UNKNOWN, V1_8, V1_9, V1_10, V1_11, V1_12, V1_13, V1_14, V1_15, V1_16;

	public static BukkitVersion detect() {
		String major = Bukkit.getBukkitVersion().split("\\.")[0];
		String minor = Bukkit.getBukkitVersion().split("\\.")[1];

		try {
			return BukkitVersion.valueOf("V" + major + "_" + minor);
		} catch (Exception ex) {
			// ignored
		}

		return UNKNOWN;
	}
}
