package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class ZombieList{
    public Zombie[] zombies;
    public int size = 0;
    
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
    
    public boolean run() {
    	Plants plant;
    	for(int i = 0; i < size; i++) {
    		plant = game.PList.get(zombies[i].getCol() - 1, zombies[i].getRow());
    		if(plant == null) plant = game.SList.get(zombies[i].getCol() - 1, zombies[i].getRow());
    		
    		if(plant != null) {
    			zombies[i].attack(plant);
    		}
    		else zombies[i].move();
    	}
    	
    	return true;
    }
}
