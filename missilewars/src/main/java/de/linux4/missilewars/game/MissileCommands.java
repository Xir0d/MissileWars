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

import de.linux4.missilewars.MissileWars;

public class MissileCommands {

	public static HashMap<String, Vector> positions = new HashMap<String, Vector>();
	static {
		positions.put("tomahawk", new Vector(0, -3, 4));
		positions.put("shieldbuster", new Vector(0, -3, 4));
		positions.put("juggernaut", new Vector(0, -3, 4));
		positions.put("lightning", new Vector(0, -3, 5));
		positions.put("guardian", new Vector(0, -3, 4));
		positions.put("shield", new Vector(0, 0, 0));
		positions.put("win", new Vector(-27, 88, -51));
	}

	public static void spawnObject(Game.PlayerTeam team, String missileName, Location location) {
		Vector position = positions.get(missileName);

		if (team == Game.PlayerTeam.GREEN) {
			position = position.clone().setZ(-position.getZ());
		}

		Location rel = location.add(position);
		MissileWars.getWorldEditUtil().pasteSchematic(team.toString().toLowerCase() + "_" + missileName, rel, true);
	}

	public static void spawnObject(Game.PlayerTeam team, String objectName, World world) {
		spawnObject(team, objectName, new Location(world, 0, 0, 0));
	}

}
