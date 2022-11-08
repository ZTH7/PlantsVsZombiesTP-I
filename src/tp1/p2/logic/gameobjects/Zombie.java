package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Zombie extends GameObject{
	
	public static int resistencia = 5;
    public static int damage = 1;
    public static int frecuencia = 2;

    public Zombie() {}
    
    public Zombie(GameWorld game, int col, int row) {
    	super(game,col,row);
		this.life = Zombie.resistencia;
		this.ciclo = Zombie.frecuencia;
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
	public void kill() {
		if (!isAlive()) {
			game.removeObj(this);
			game.reduceZombie();
		}
	}

	@Override
	protected boolean isAlive() {
		return life > 0;
	}

	@Override
	protected String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}

	@Override
	public void update() {
		if(isAlive()) {
			GameItem item = game.getGameObjectInPosition(col - 1, row);
			if(item == null || !item.receiveZombieAttack(damage)) {
				move();
				GameItem it = game.getGameObjectInPosition(col - 1, row);
				if(it != null) it.receiveZombieAttack(damage);
			}
			if(col < 0) game.zombieWins();			
		}
	}
	
	public boolean move(){
    	if(this.ciclo == 0) {
    		this.col--;
    		this.ciclo = frecuencia;
    	} else this.ciclo--;
        
        return true;
    }

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

	public Zombie create(GameWorld game, int col, int row) {
		return new Zombie(game,col,row);
	}
}
