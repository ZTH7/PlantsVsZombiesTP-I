package tp1.p1.logic;

import java.util.Random;
import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.*;
import tp1.p1.view.Messages;

public class Game {

    public static int NUM_COLS = 8;
    public static int NUM_ROWS = 4;
    
    public int soles = 50;
    public int CicloContador = 0;
    public Level level;
    
    
    public ZombiesManager zombiesManager;
    private Random rand;

    public SunflowerList SList = new SunflowerList(NUM_COLS, NUM_ROWS);
    public PeashooterList PList = new PeashooterList(NUM_COLS, NUM_ROWS);
    
    public Game(long seed, Level level){
    	this.level = level;
        rand = new Random(seed);
        zombiesManager = new ZombiesManager(this, level, rand);
    }

    public boolean update() {
    	SList.run();
    	PList.run();
    	zombiesManager.run();
    	
    	SList.clear();
    	PList.clear();
    	zombiesManager.clear();

    	zombiesManager.addZombie();
    	
        CicloContador++;

        return true;
    }
    
    public boolean checkOver() {
    	return zombiesManager.checkZombieWin() || zombiesManager.checkPlayerWin();
    }
    
    public boolean Reset() {
        this.soles = 50;
        this.CicloContador = 0;
    	this.SList = new SunflowerList(NUM_COLS, NUM_ROWS);
        this.PList = new PeashooterList(NUM_COLS, NUM_ROWS);
        this.zombiesManager = new ZombiesManager(this, this.level, rand);
        return true;
    }

    public String positionToString(int col, int row) {

        Zombie zomb = zombiesManager.get(col, row);
        if (zomb != null) {
        	return String.format(Messages.ZOMBIE_ICON, zomb.getVida());
        }
        Plants sunf = SList.get(col, row);
        if (sunf != null) {
        	return String.format(Messages.SUNFLOWER_ICON, sunf.getVida());
        }
        Plants peas = PList.get(col, row);
        if (peas != null) {
        	return String.format(Messages.PEASHOOTER_ICON, peas.getVida());
        }

        return "";
    }
}
