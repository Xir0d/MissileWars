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
package de.linux4.missilewars.v112;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

import de.linux4.missilewars.v113.MissileWarsBukkit113;

public class MissileWarsBukkit112 extends MissileWarsBukkit113 {

	@SuppressWarnings("deprecation")
	@Override
	public FallingBlock spawnFallingBlock(Location location, Block block) {
		return location.getWorld().spawnFallingBlock(location, block.getType(), block.getData());
	}

	@Override
	public Material getNetherPortalMaterial() {
		return Material.PORTAL;
	}

	@Override
	public Material getSnowBallMaterial() {
		return Material.SNOW_BALL;
	}

	@Override
	public Material getFireChargeMaterial() {
		return Material.FIREBALL;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ItemStack newSpawnEgg(EntityType entity) {
		ItemStack egg = new ItemStack(Material.MONSTER_EGG, 1);

		egg.setDurability(entity.getTypeId());

		return egg;
	}

	@Override
	public String getMapName() {
		return "map1-8";
	}

	@Override
	public void setTeamColor(Team team, ChatColor color) {
		team.setPrefix("§" + color.getChar());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void cloneBlockData(Block source, Block target) {
		target.setData(source.getData());
	}

}
