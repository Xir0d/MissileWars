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
package de.linux4.missilewars.v112.world;

import java.io.File;

import org.bukkit.Location;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.schematic.SchematicFormat;
import com.sk89q.worldedit.world.World;

import de.linux4.missilewars.world.WorldEditUtil;

public class WorldEditUtil112 extends WorldEditUtil {

	private final File schematicFolder;

	public WorldEditUtil112(File schematicFolder) {
		this.schematicFolder = schematicFolder;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void pasteSchematic(String name, Location loc, boolean ignoreAir) {
		try {
			File schematic = new File(this.schematicFolder, name + ".schematic");
			World worldEditWorld = new BukkitWorld(loc.getWorld());
			EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(worldEditWorld,
					-1);
			SchematicFormat.getFormat(schematic).load(schematic).paste(editSession,
					new Vector(loc.getX(), loc.getY(), loc.getZ()), ignoreAir);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
