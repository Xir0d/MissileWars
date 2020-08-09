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
package de.linux4.missilewars.v113;

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
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

import de.linux4.missilewars.MissileWarsBukkit;
import de.linux4.missilewars.NameTagVisibility;

public class MissileWarsBukkit113 implements MissileWarsBukkit {

	@Override
	public FallingBlock spawnFallingBlock(Location location, Block block) {
		return location.getWorld().spawnFallingBlock(location, block.getBlockData());
	}

	@Override
	public Material getNetherPortalMaterial() {
		return Material.NETHER_PORTAL;
	}

	@Override
	public Material getSnowBallMaterial() {
		return Material.SNOWBALL;
	}

	@Override
	public Material getFireChargeMaterial() {
		return Material.FIRE_CHARGE;
	}

	@Override
	public ItemStack newSpawnEgg(EntityType entity) {
		switch (entity) {
		case CREEPER:
			return new ItemStack(Material.CREEPER_SPAWN_EGG, 1);
		case SHEEP:
			return new ItemStack(Material.SHEEP_SPAWN_EGG, 1);
		case WITCH:
			return new ItemStack(Material.WITCH_SPAWN_EGG, 1);
		case GUARDIAN:
			return new ItemStack(Material.GUARDIAN_SPAWN_EGG, 1);
		case OCELOT:
			return new ItemStack(Material.OCELOT_SPAWN_EGG, 1);
		default:
			return null;
		}
	}

	@Override
	public String getMapName() {
		return "map1-13";
	}

	@Override
	public void setTeamColor(Team team, ChatColor color) {
		team.setColor(color);
	}

	@Override
	public void setUnbreakable(ItemMeta meta, boolean unbreakable) {
		meta.setUnbreakable(unbreakable);
	}

	@Override
	public ItemStack getItemInMainHand(Player player) {
		return player.getInventory().getItemInMainHand();
	}

	@Override
	public void setItemInMainHand(Player player, ItemStack item) {
		player.getInventory().setItemInMainHand(item);
	}

	@Override
	public Sound getLevelUpSound() {
		return Sound.ENTITY_PLAYER_LEVELUP;
	}

	@Override
	public void setNameTagVisibility(Team team, NameTagVisibility visibility) {
		OptionStatus status = null;

		switch (visibility) {
		case ALWAYS:
			status = OptionStatus.ALWAYS;
			break;
		case HIDE_FOR_OTHER_TEAMS:
			status = OptionStatus.FOR_OWN_TEAM;
			break;
		case HIDE_FOR_OWN_TEAM:
			status = OptionStatus.FOR_OTHER_TEAMS;
			break;
		case NEVER:
			status = OptionStatus.NEVER;
			break;
		default:
			break;

		}

		team.setOption(Option.NAME_TAG_VISIBILITY, status);
	}

}
