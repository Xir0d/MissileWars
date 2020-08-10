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

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

import de.linux4.missilewars.world.MWStructureUtil;

public class MissileCommands {

	public static HashMap<String, Vector> positions = new HashMap<String, Vector>();
	static {
		positions.put("shield", new Vector(0, 0, 0));
		positions.put("tomahawk", new Vector(0, -3, 4));
		positions.put("shieldbuster", new Vector(0, -3, 4));
		positions.put("juggernaut", new Vector(0, -3, 4));
		positions.put("lightning", new Vector(0, -3, 5));
		positions.put("guardian", new Vector(0, -3, 4));
		positions.put("win", new Vector(-27, 88, -51));
	}
	public static HashMap<String, Vector> missilesRelative = new HashMap<String, Vector>();
	static {
		missilesRelative.put("shield", new Vector(-115, 62, -1));
		missilesRelative.put("tomahawk", new Vector(-113, 61, -24));
		missilesRelative.put("shieldbuster", new Vector(-108, 61, -24));
		missilesRelative.put("juggernaut", new Vector(-103, 62, -24));
		missilesRelative.put("lightning", new Vector(-98, 62, 16));
		missilesRelative.put("guardian", new Vector(-93, 62, -25));
		missilesRelative.put("win", new Vector(-268, 200, -100));
	}
	public static HashMap<String, Vector> missilesStart = new HashMap<String, Vector>();
	static {
		missilesStart.put("shield", new Vector(-112, 65, -1));
		missilesStart.put("tomahawk", new Vector(-113, 62, -12));
		missilesStart.put("shieldbuster", new Vector(-107, 63, -24));
		missilesStart.put("juggernaut", new Vector(-102, 61, -24));
		missilesStart.put("lightning", new Vector(-97, 61, 16));
		missilesStart.put("guardian", new Vector(-91, 61, -25));
		missilesStart.put("win", new Vector(-253, 217, -91));
	}
	public static HashMap<String, Vector> missilesEnd = new HashMap<String, Vector>();
	static {
		missilesEnd.put("shield", new Vector(-118, 59, -1));
		missilesEnd.put("tomahawk", new Vector(-111, 61, -24));
		missilesEnd.put("shieldbuster", new Vector(-109, 61, -10));
		missilesEnd.put("juggernaut", new Vector(-104, 63, -14));
		missilesEnd.put("lightning", new Vector(-99, 62, 24));
		missilesEnd.put("guardian", new Vector(-94, 63, -18));
		missilesEnd.put("win", new Vector(-283, 200, -113));
	}

	public static void spawnObject(Game.PlayerTeam team, String missileName, Location location) {
		Vector position = positions.get(missileName);
		Vector relative = missilesRelative.get(missileName);
		Vector start = missilesStart.get(missileName);
		Vector end = missilesEnd.get(missileName);

		if (team == Game.PlayerTeam.GREEN) {
			position = position.clone().setZ(-position.getZ());
			relative = relative.clone().setZ(-relative.getZ());
			start = start.clone().setZ(-start.getZ());
			end = end.clone().setZ(-end.getZ());

			if ("guardian".equalsIgnoreCase(missileName)) { // TODO: dirty fixes
				start.setX(start.getX() - 1);
				end.setX(end.getX() - 1);
				relative.setX(relative.getX() - 1);
			} else if ("tomahawk".equalsIgnoreCase(missileName)) {
				relative.setX(relative.getX() + 1);
			}
		}

		Location rel = location.add(position);
		Location pasteRel = new Location(rel.getWorld(), relative.getX(), relative.getY(), relative.getZ());
		Location pasteStart = new Location(rel.getWorld(), start.getX(), start.getY(), start.getZ());
		Location pasteEnd = new Location(rel.getWorld(), end.getX(), end.getY(), end.getZ());

		MWStructureUtil.clone(pasteRel, pasteStart, pasteEnd, rel, true);
	}

	public static void spawnObject(Game.PlayerTeam team, String objectName, World world) {
		spawnObject(team, objectName, new Location(world, 0, 0, 0));
	}

}
