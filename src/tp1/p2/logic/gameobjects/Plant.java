package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;

public abstract class Plant extends GameObject{

	Plant(){}
	
	Plant(GameWorld game, int col, int row) {
		this.game = game;
		this.col = col;
		this.row = row;
	}
	
	@Override
	protected boolean isAlive() {
		return life > 0;
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		if(isAlive()) {
			life -= damage;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean receivePlantAttack(int damage) {
		return false;
	}

	public abstract String getName();
	
	protected abstract Plant create(GameWorld game, int col, int row);
	
	public abstract int getCost();
}
