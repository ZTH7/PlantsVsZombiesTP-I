package tp1.p2.logic;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
//import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;

	// TODO add your code here
	void playerQuits();
	
	void zombieWins();

    ExecutionResult update();
    
    void addPlant(GameObject plant);
    
    void addZombie(GameObject zombie);
    
    void removeObj(GameObject obj);
    
    GameObject getGameObjectInPosition(int col, int row);
    
    void Reset(Level level, long seed);
    
    boolean execute(Command command);
    
    void reduceZombie();
    
    boolean addSoles(int num);
}
