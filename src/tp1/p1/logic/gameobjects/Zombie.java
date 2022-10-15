package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class Zombie extends GameObj {
	
	public static int resistencia = 5;
    public static int damage = 1;
    public static int frecuencia = 1;
    
    Game game;
    
	public Zombie(int col, int row, Game game) {
		this.col = col;
		this.row = row;
		this.vida = Zombie.resistencia;
		this.game = game;
		ciclo = frecuencia;
	}
    
    public boolean damage(int val) {
    	if(this.vida > 0) {
    		this.vida -= val;
    		return true;
    	}
    	
    	return false;
    }

    public boolean move(){
    	if(this.ciclo == 0) {
    		this.col--;
    		this.ciclo = frecuencia;
    	} else this.ciclo--;
        
        return true;
    }
    
    public boolean attack(GameObj plant) {
    	boolean res = false;
    	res = plant.damage(damage);
    	this.ciclo = frecuencia;
        
        return res;
    }
    
    @Override
    public boolean execute() {
    	GameObj plant = game.getPlant(col - 1, row);
    	if(plant != null) attack(plant);
    	else move();
    	return true;
    }
}
