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
package de.linux4.missilewars;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Team;

public interface MissileWarsBukkit {

	public FallingBlock spawnFallingBlock(Location location, Block block);

	public Material getNetherPortalMaterial();

	public Material getFireChargeMaterial();

	public Material getSnowBallMaterial();

	public ItemStack newSpawnEgg(EntityType entity);

	public String getMapName();

	public void setTeamColor(Team team, ChatColor color);

	public void setUnbreakable(ItemMeta meta, boolean unbreakable);

	public ItemStack getItemInMainHand(Player player);

	public void setItemInMainHand(Player player, ItemStack item);

	public Sound getLevelUpSound();

	public void setNameTagVisibility(Team team, NameTagVisibility visibility);

}
