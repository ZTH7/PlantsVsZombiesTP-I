package tp1.p2.logic;

import java.util.Random;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public class Game implements GameWorld, GameStatus {
	private int Cycle;
	private Level level;
	private long seed = 0;
	private int SunCoins = INITIAL_SUNCOINS;
	private boolean zombieWins;
    private boolean playerQuits;
	private ZombiesManager zombiesManager;
	private GameObjectContainer gameObjContainer;
	public static final int INITIAL_SUNCOINS = 50;

	
	public Game(long seed, Level level){
		Reset(level, seed);
    }

	@Override
	public void reduceZombie() {
		zombiesManager.reduceZombie();
	}

	@Override
	public int getCycle() {
		return Cycle;
	}


	@Override
	public int getSuncoins() {
		return SunCoins;
	}


	@Override
	public String positionToString(int col, int row) {
		GameObject obj = getGameObjectInPosition(col, row);
		if(obj != null)return obj.toString();
		else return "";
	}


	@Override
	public boolean isFinished() {
		return playerQuits || zombieWins || zombiesManager.checkPlayerWin();
	}


	@Override
	public boolean isPlayerQuits() {
		return playerQuits;
	}


	@Override
	public int getRemainingZombies() {
		return zombiesManager.getRemainingZombies();
	}


	@Override
	public void playerQuits() {
		playerQuits = true;
	}


	@Override
	public ExecutionResult update() {
		zombiesManager.update();
		
		gameObjContainer.update();
		
		Cycle++;
		
		return new ExecutionResult(true);
	}


	@Override
	public void addPlant(GameObject plant) {
		gameObjContainer.add(plant);
	}


	@Override
	public void addZombie(GameObject zombie) {
		gameObjContainer.add(zombie);
	}


	@Override
	public GameObject getGameObjectInPosition(int col, int row) {
		return gameObjContainer.get(col, row);
	}


	@Override
	public void Reset(Level level, long seed) {
        this.Cycle = 0;
        this.zombieWins = false;
		this.playerQuits = false;
		this.SunCoins = INITIAL_SUNCOINS;
		
        if(level != null) this.level = level;
        if(seed != 0) this.seed = seed;
        
        this.gameObjContainer = new GameObjectContainer();
        this.zombiesManager = new ZombiesManager(this, this.level, new Random(this.seed));

		System.out.println(String.format(Messages.CONFIGURED_LEVEL, this.level.name()));
		System.out.println(String.format(Messages.CONFIGURED_SEED, this.seed));
	}


	@Override
	public boolean execute(Command command) {
		ExecutionResult res = command.execute(this);
		if(!res.success()) System.out.println(res.errorMessage());
		return res.draw();
	}


	@Override
	public void zombieWins() {
		zombieWins = true;
	}


	@Override
	public void removeObj(GameObject obj) {
		gameObjContainer.remove(obj);
	}


	@Override
	public boolean addSoles(int num) {
		int res = SunCoins + num;
		if(res < 0) return false;
		else {
			SunCoins = res;
			return true;
		}
	}

	@Override
	public boolean isZombieWins() {
		return zombieWins;
	}
	
}
