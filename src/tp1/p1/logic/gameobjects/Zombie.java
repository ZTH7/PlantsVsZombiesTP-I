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
    	if(!game.hurtPlant(col - 1, row, damage)) move();
    	return true;
    }
}
