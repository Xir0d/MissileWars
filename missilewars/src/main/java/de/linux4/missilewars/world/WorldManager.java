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
package de.linux4.missilewars.world;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class WorldManager {

	private Slot active;
	private static final String NAME_PREFIX = "game";
	private String mapname;

	public WorldManager() {
		this.active = Slot.A;
		mapname = Bukkit.getBukkitVersion().contains("1.13") ? "map" : "map14";
		init();
	}

	private void init() {
		deleteWorldSlot(Slot.A);
		deleteWorldSlot(Slot.B);
		loadWorldSlot(Slot.A);
		loadWorldSlot(Slot.B);
	}

	public World getActiveWorld() {
		return Bukkit.getWorld(NAME_PREFIX + active);
	}

	public World getInactiveWorld() {
		return Bukkit.getWorld(NAME_PREFIX + active.nextSlot());
	}

	public void nextSlot() {
		deleteWorldSlot(active);
		loadWorldSlot(active);
		active = active.nextSlot();
	}

	private void deleteWorldSlot(Slot slot) {
		Bukkit.unloadWorld(NAME_PREFIX + slot, false);
		try {
			FileUtils.deleteDirectory(new File(Bukkit.getWorldContainer(), NAME_PREFIX + slot));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadWorldSlot(Slot slot) {
		File mapFolder = new File(Bukkit.getWorldContainer(), NAME_PREFIX + slot);
		try {
			ZipFile zip = new ZipFile(
					new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
			Enumeration<? extends ZipEntry> entries = zip.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				if (entry.getName().startsWith(mapname + "/")) {
					File file = new File(mapFolder,
							entry.getName().substring((mapname + "/").length(), entry.getName().length()));
					if (entry.isDirectory()) {
						file.mkdirs();
					} else {
						InputStream in = zip.getInputStream(entry);
						FileOutputStream out = new FileOutputStream(file);
						IOUtils.copy(in, out);
						in.close();
						out.close();
					}
				}
			}
			zip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		WorldCreator wc = new WorldCreator(NAME_PREFIX + slot);
		wc.environment(World.Environment.NORMAL);
		Bukkit.getServer().createWorld(wc);
	}

	public Slot getActiveSlot() {
		return active;
	}

	public Slot getInactiveSlot() {
		return active.nextSlot();
	}

	public enum Slot {
		A, B;

		public Slot nextSlot() {
			return this == A ? B : A;
		}
	}
}
