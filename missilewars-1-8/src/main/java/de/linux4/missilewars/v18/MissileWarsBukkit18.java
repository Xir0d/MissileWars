package de.linux4.missilewars.v18;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

import de.linux4.missilewars.NameTagVisibility;
import de.linux4.missilewars.v110.MissileWarsBukkit110;

public class MissileWarsBukkit18 extends MissileWarsBukkit110 {

	@Override
	public ItemStack getItemInMainHand(Player player) {
		return player.getItemInHand();
	}

	@Override
	public Sound getLevelUpSound() {
		return Sound.LEVEL_UP;
	}

	@Override
	public void setNameTagVisibility(Team team, NameTagVisibility visibility) {
		team.setNameTagVisibility(org.bukkit.scoreboard.NameTagVisibility.valueOf(visibility.toString()));
	}

}
