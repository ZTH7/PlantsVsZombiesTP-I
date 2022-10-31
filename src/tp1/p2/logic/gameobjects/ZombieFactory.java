package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class ZombieFactory {

	/* @formatter:off */
	private static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
		new Zombie()
	);
	/* @formatter:on */

	public static Zombie spawnZombie(int zombieType, GameWorld game, int col, int row) {
		return AVAILABLE_ZOMBIES.get(zombieType).create(game, col, row);
	}

	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}

	/*
	 * Avoid creating instances of this class
	 */
	private ZombieFactory() {
	}
}
