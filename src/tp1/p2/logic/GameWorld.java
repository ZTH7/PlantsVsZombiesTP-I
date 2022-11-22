package tp1.p2.logic;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	// TODO add your code here

	void addSun();

	boolean tryToCatchObject(int col, int row);

	boolean addItem(GameObject item);

	// TODO add your code here
	void reset();
	
	void reset(Level level, long seed);
	
	void update();
	
	void zombieWins();
	
	void playerQuits();
	
	void reduceZombie();
	
	boolean addSunCoin(int num);
	
	boolean execute(Command command);
	
	GameItem getGameItemInPosition(int col, int row);
	
	void pushAction(GameAction gameAction);
	
	boolean isPositionEmpty(int col, int row);
	//End
}
