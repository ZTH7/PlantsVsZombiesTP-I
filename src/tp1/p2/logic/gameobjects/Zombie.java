package tp1.p2.logic.gameobjects;

import static tp1.p2.view.Messages.zombieDescription;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Zombie extends GameObject{
	public static int endurance = 5;
    public static int damage = 1;
    public static int frecuencia = 2;
    public static int speed = 2;

    public Zombie() {}
    
    public Zombie(GameWorld game, int col, int row) {
    	super(game,col,row);
		this.life = endurance;
		this.ciclo = speed;
	}

	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}

	@Override
	public boolean receivePlantAttack(int damage) {
		if(isAlive()) {
			life -= damage;
			return true;
		}
		return false;
	}

	@Override
	public boolean isAlive() {
		return life > 0;
	}

	@Override
	protected String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}

	@Override
	public String getDescription() {
		return zombieDescription(Messages.ZOMBIE_NAME, speed, damage, endurance);
	}

	public boolean move(){
    	if(this.ciclo == 0) {
    		this.col--;
    		this.ciclo = speed - 1;
    	} else this.ciclo--;
        
        return true;
    }
	
	@Override
	public void update() {
		if(isAlive()) {
			GameItem item = game.getGameItemInPosition(col - 1, row);
			if(item == null || !item.receiveZombieAttack(damage)) {
				move();
				GameItem it = game.getGameItemInPosition(col - 1, row);
				if(it != null) it.receiveZombieAttack(damage);
			}
			if(col < 0) game.zombieWins();			
		}
	}

	@Override
	public void onEnter() {}

	@Override
	public void onExit() {}
	
	public Zombie create(GameWorld game, int col, int row) {
		return new Zombie(game,col,row);
	}
}
