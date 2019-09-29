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
package de.linux4.missilewars.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

import de.linux4.missilewars.MissileWars;

public class MissileCommands {

	private CommandSender console = Bukkit.getConsoleSender();

	public void greenTomahawk(Player p) {
		relativePaste("green_tomahawk", p, -0.5, -3, -4);
	}

	public void redTomahawk(Player p) {
		relativePaste("red_tomahawk", p, -0.5, -3, 4);
	}

	public void greenShieldBuster(Player p) {
		relativePaste("green_shieldbuster", p, -0.5, -3, -4);
	}

	public void redShieldBuster(Player p) {
		relativePaste("red_shieldbuster", p, -0.5, -3, 4);
	}

	public void greenJuggernaut(Player p) {
		relativePaste("green_juggernaut", p, -0.5, -3, -4);
	}

	public void redJuggernaut(Player p) {
		relativePaste("red_juggernaut", p, -0.5, -3, 4);
	}

	public void greenLightning(Player p) {
		relativePaste("green_lightning", p, -0.5, -3, -5);
	}

	public void redLightning(Player p) {
		relativePaste("red_lightning", p, -0.5, -3, 5);
	}

	public void greenGuardian(Player p) {
		relativePaste("green_guardian", p, -0.5, -3, -4);
	}

	public void redGuardian(Player p) {
		relativePaste("red_guardian", p, -0.5, -3, 4);
	}

	public void redShield(Snowball snowball) {
		MissileWars.getWorldEditUtil().pasteSchematic("red_shield", snowball.getLocation(), true);
	}

	public void greenShield(Snowball snowball) {
		MissileWars.getWorldEditUtil().pasteSchematic("green_shield", snowball.getLocation(), true);
	}

	public void redWin() {
		MissileWars.getWorldEditUtil().pasteSchematic("red_win",
				new Location(MissileWars.getWorldManager().getActiveWorld(), -27, 88, -51), true);
	}

	public void greenWin() {
		MissileWars.getWorldEditUtil().pasteSchematic("green_win",
				new Location(MissileWars.getWorldManager().getActiveWorld(), -27, 88, 51), true);
	}

	protected void command(String cmd) {
		Bukkit.dispatchCommand(console, cmd);
	}

	protected void relativePaste(String name, Player p, double relX, double relY, double relZ) {
		Location rel = new Location(p.getWorld(), p.getLocation().getX() + relX, p.getLocation().getY() + relY,
				p.getLocation().getZ() + relZ);
		MissileWars.getWorldEditUtil().pasteSchematic(name, rel, true);
	}

}
