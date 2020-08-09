/*******************************************************************************
 * Copyright (C) 2020 Linux4
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package de.linux4.missilewars.v110;

import org.bukkit.inventory.meta.ItemMeta;

import de.linux4.missilewars.v112.MissileWarsBukkit112;

public class MissileWarsBukkit110 extends MissileWarsBukkit112 {

	@Override
	public void setUnbreakable(ItemMeta meta, boolean unbreakable) {
		meta.spigot().setUnbreakable(unbreakable);
	}

}
