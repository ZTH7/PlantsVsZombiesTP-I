package tp1.p1.logic;

import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.*;

public class Game {
	
	public int CicloContador = 0;
	public int soles = 50;
	public static int NUM_COLS = 8;
	public static int NUM_ROWS = 4;
	public long seed;
	public Level level;
	
	public boolean update = false;
	
	public ZombiesManager zombieMan;
	
	public SunflowerList Slist;
	public PeashooterList Plist;
	
	
	public Game(long seed, Level level){
		this.seed = seed;
		this.level = level;
	}
	
	public boolean update() {
		
		update = true;
		
		System.out.println("Number of cycles: " + CicloContador);
		System.out.println("Sun coins: " + soles);
		//System.out.println("Remaining zombies: " + );
		
		return true;
	}
	
	public String positionToString(int col, int row) {
		String res = "";
		
		
		
		
		return res;
	}
}
