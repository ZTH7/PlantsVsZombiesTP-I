package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class ZombieList extends GameObjList{    
    public ZombieList(int remainingZombies){
        this.list = new Zombie[remainingZombies];
    }
    
    public boolean add(int col, int row, Game game) {
        Zombie zombies = new Zombie(col, row, game);
        this.list[size] = zombies;
        this.size++;

        return true;
    }
    
    public boolean checkZombieWin() {
		for(int i = 0; i < this.size; i++) {
    		if(this.list[i].getCol() < 0) return true;
    	}
		return false;
	}
    
    public int getSize() {
    	return this.size;
    }
}
