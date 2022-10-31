package tp1.p2.logic.gameobjects;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Sunflower extends Plant {
	public static int coste = 20;
    public static int resistencia = 1;
    public static int damage = 0;
    public static int frecuencia = 3;	

    public Sunflower() {}
    
    public Sunflower(GameWorld game, int col, int row) {
    	this.life = Sunflower.resistencia;
    	this.col = col;
    	this.row = row;
    	this.game = game;
    	
    	this.ciclo = Sunflower.frecuencia;
    }
    
	@Override
	protected String getSymbol() {
		return Messages.SUNFLOWER_SYMBOL;
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.SUNFLOWER_NAME_SHORTCUT, coste, damage, resistencia);
	}

	@Override
	public void update() {
		if(isAlive()) {
			if(this.ciclo == 0) {
	    		game.addSoles(10);
	    		this.ciclo = Sunflower.frecuencia - 1;
	    	} else this.ciclo--;
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
		return Messages.SUNFLOWER_NAME;
	}

	@Override
	protected Plant create(GameWorld game, int col, int row) {
		return new Sunflower(game, col, row);
	}

	@Override
	public int getCost() {
		return coste;
	}

}
