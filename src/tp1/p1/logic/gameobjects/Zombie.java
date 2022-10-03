package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class Zombie {
	
	public static int resistencia = 3;
    public static int damage = 1;
    
	private int vida;
    private int col;
    private int row;
    
    Game game;
    
	public Zombie(int col, int row, Game game) {
		this.col = col;
		this.row = row;
		this.vida = Zombie.resistencia;
		this.game = game;
	}

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getVida() {
        return vida;
    }
    
    public boolean damage(int val) {
    	if(this.vida > 0) {
    		this.vida -= val;
    		return true;
    	}
    	return false;
    }

    public boolean move(){
        this.col--;
        return true;
    }
    
    public boolean attack(Plants plant) {
    	return plant.damage(damage);
    }
}
