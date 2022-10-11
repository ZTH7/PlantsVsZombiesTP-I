package tp1.p1.logic;

import java.util.Random;

import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.Zombie;
import tp1.p1.logic.gameobjects.ZombieList;

/**
 * Manage zombies in the game.
 *
 */
public class ZombiesManager {

	private Game game;

	private Level level;

	private Random rand;

	private int remainingZombies;

	private ZombieList zombies;

	public ZombiesManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
		this.zombies = new ZombieList(this.remainingZombies);
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 *
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}

	/**
	 * Return a random row within the board limits.
	 *
	 * @return a random row.
	 */
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}

	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	public boolean addZombie(int row) {
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie()
				&& isPositionEmpty(Game.NUM_COLS, row);

		if(canAdd) {
			// TODO fill your code
			zombies.add(Game.NUM_COLS, row, game);
			remainingZombies--;
			//End
		}
		return canAdd;
	}

	// TODO fill your code
	public int getRemainingZombies() {
		return remainingZombies;
	}

	public Zombie get(int col, int row) {
		return zombies.get(col, row);
	}
	
	public boolean run() {
		return zombies.run();
	}
	
	public boolean clear() {
		return zombies.clear();
	}
	
	public boolean checkZombieWin() {
		return zombies.checkZombieWin();
	}
	
	public boolean checkPlayerWin() {
		return remainingZombies <= 0 && zombies.getSize() <= 0;
	}
	
	public boolean isPositionEmpty(int col, int row){
		return zombies.get(col, row) == null;
	}
}
