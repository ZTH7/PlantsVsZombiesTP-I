package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;

public class PlantFactory {

	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(),
		new Peashooter(),
		new WallNut(),
		new CherryBomb()
	);
	/* @formatter:on */

	public static boolean isValidPlant(String plantName) {
		for (Plant p : AVAILABLE_PLANTS) {
			// TODO add your code here
			String shortcut = p.getSymbol();
			String name = p.getName();
			if (shortcut.equalsIgnoreCase(plantName) || name.equalsIgnoreCase(plantName)) return true;
		}

		return false;
	}

	public static Plant spawnPlant(String plantName, GameWorld game, int col, int row) throws GameException {
		// TODO add your code here
		for (Plant p : AVAILABLE_PLANTS) {
			// TODO add your code here
			String shortcut = p.getSymbol();
			String name = p.getName();
			if (shortcut.equalsIgnoreCase(plantName) || name.equalsIgnoreCase(plantName)) {
				return p.create(game, col, row);
			}
		}
		return null;
	}

	public static Iterable<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}

	/*
	 * Avoid creating instances of this class
	 */
	private PlantFactory() {
	}
}
