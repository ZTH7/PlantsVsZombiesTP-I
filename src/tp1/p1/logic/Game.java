package tp1.p1.logic;

import java.util.Random;
import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.*;
import tp1.p1.view.Messages;

public class Game {

    public static int NUM_COLS = 8;
    public static int NUM_ROWS = 4;
    
    private int soles = 50;
    private int CicloContador = 0;
    private Level level;
    
    
    private ZombiesManager zombiesManager;
    private Random rand;
    private boolean exit = false;
    private SunflowerList SList = new SunflowerList(NUM_COLS, NUM_ROWS);
    private PeashooterList PList = new PeashooterList(NUM_COLS, NUM_ROWS);
    
    public Game(long seed, Level level){
    	this.level = level;
        rand = new Random(seed);
        zombiesManager = new ZombiesManager(this, level, rand);
    }

    public boolean update() {
    	SList.run();
    	PList.run();
    	zombiesManager.clear();
    	
    	zombiesManager.run();
    	SList.clear();
    	PList.clear();

    	zombiesManager.addZombie();
    	
        CicloContador++;
        
        return true;
    }
    
    public boolean checkOver() {
    	return zombiesManager.checkZombieWin() || zombiesManager.checkPlayerWin() || exit;
    }
    
    public boolean Reset() {
        this.soles = 50;
        this.CicloContador = 0;
    	this.SList = new SunflowerList(NUM_COLS, NUM_ROWS);
        this.PList = new PeashooterList(NUM_COLS, NUM_ROWS);
        this.zombiesManager = new ZombiesManager(this, this.level, rand);
        return true;
    }

//    public GameObj getPlant(int col, int row) {
//    	GameObj plant;
//    	plant = SList.get(col, row);
//		if(plant == null) plant = PList.get(col, row);
//    	return plant;
//    }
    
    public int getCicloContador() {
    	return this.CicloContador;
    }
    
    public void addCicloContador() {
    	this.CicloContador++;
    }
    
    public int getSoles() {
    	return this.soles;
    }
    
    public void addSoles(int num) {
    	this.soles += num;
    }
    
    public void playerExit() {
    	exit = true;
    }
    
    public boolean ifPlayerExit() {
    	return exit;
    }
    
    public void addPeashooter(int col, int row, Game game) {
    	PList.add(col, row, game);
    }
    
    public void addSunflower(int col, int row, Game game) {
    	SList.add(col, row, game);
    }
    
    public boolean hurtZombie(int col, int row, int damage) {
    	return zombiesManager.hurtZombie(col, row, damage);
    }
    
    public boolean hurtPlant(int col, int row, int damage) {
    	return SList.hurt(col, row, damage) || PList.hurt(col, row, damage);
    }
    
    public boolean hasPlant(int col, int row) {
    	return SList.hasObj(col, row) || PList.hasObj(col, row);
    }
    
    public boolean hasZombie(int col, int row) {
    	return zombiesManager.hasObj(col, row);
    }
    
//    public Zombie getZombie(int col, int row) {
//    	return (Zombie)zombiesManager.get(col, row);
//    }
    
    public int getRemainingZombies() {
    	return zombiesManager.getRemainingZombies();
    }
    
    public String positionToString(int col, int row) {

        if (zombiesManager.hasObj(col, row)) {
        	return String.format(Messages.ZOMBIE_ICON, zombiesManager.getVida(col, row));
        }
        if (SList.hasObj(col, row)) {
        	return String.format(Messages.SUNFLOWER_ICON, SList.getVida(col, row));
        }
        if (PList.hasObj(col, row)) {
        	return String.format(Messages.PEASHOOTER_ICON, PList.getVida(col, row));
        }

        return "";
    }
}
