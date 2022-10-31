package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	public static int coste = 50;
    public static int resistencia = 3;
    public static int damage = 1;
    public static int frecuencia = 1;
    
    public Peashooter() {}
    
    public Peashooter(GameWorld game, int col, int row) {
    	this.life = Peashooter.resistencia;
    	this.col = col;
    	this.row = row;
    	this.game = game;
    	this.ciclo = Sunflower.frecuencia;
    }

	@Override
	protected String getSymbol() {
		return Messages.PEASHOOTER_SYMBOL;
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.PEASHOOTER_NAME_SHORTCUT, coste, damage, resistencia);
	}

	@Override
	public void update() {
		if(isAlive()) {
			for(int i = this.col; i < GameWorld.NUM_COLS; i++) {
				GameItem item = game.getGameObjectInPosition(i, row);
				if(item != null && item.receivePlantAttack(damage)) break;
			}
    	}
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return Messages.PEASHOOTER_NAME;
	}

	@Override
	protected Plant create(GameWorld game, int col, int row) {
		return new Peashooter(game, col, row);
	}

	@Override
	public int getCost() {
		return coste;
	}

}
