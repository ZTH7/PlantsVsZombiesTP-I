package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class ZombieList{
    private Zombie[] zombies;
    private int size = 0;
    
    Game game;
    
    public ZombieList(int remainingZombies){
        zombies = new Zombie[remainingZombies];
    }
    
    public boolean add(int col, int row, Game game) {
    	this.game = game;
        Zombie zombies = new Zombie(col, row, game);
        this.zombies[size] = zombies;
        this.size++;

        return true;
    }    

    public boolean clear() {
		for(int i = 0; i < this.size; i++) {
    		if(zombies[i].getVida() <= 0) {
    			for(int j = i + 1; j < this.size; j++) {
    				zombies[j - 1] = zombies[j];
    	    	}
    			this.size--;
    			i--;
    		}
    	}
		return true;
	}
    
    public Zombie get(int col, int row) {
		for(int i = 0; i < this.size; i++) {
    		if(this.zombies[i].getCol() == col && this.zombies[i].getRow() == row) {
    			return this.zombies[i];
    		}
    	}
		return null;
	}
    
    public boolean checkZombieWin() {
		for(int i = 0; i < this.size; i++) {
    		if(this.zombies[i].getCol() < 0) return true;
    	}
		return false;
	}
    
    public int getSize() {
    	return this.size;
    }
    
    public boolean run() {
    	Plants plant;
    	for(int i = 0; i < size; i++) {
    		plant = game.getPlant(zombies[i].getCol() - 1, zombies[i].getRow());
    		
    		if(plant != null) {
    			zombies[i].attack(plant);
    		}
    		else zombies[i].move();
    	}
    	
    	return true;
    }
}
