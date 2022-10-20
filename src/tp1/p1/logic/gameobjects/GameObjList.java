package tp1.p1.logic.gameobjects;

import tp1.p1.logic.*;

public abstract class GameObjList {
	protected GameObj[] list;
	protected int size = 0;

    public abstract boolean add(int col, int row, Game game);
    
//    public GameObj get(int col, int row) {
//    	for(int i = 0; i < this.size; i++) {
//    		if(this.list[i].getCol() == col && this.list[i].getRow() == row) {
//    			return this.list[i];
//    		}
//    	}
//    	return null;
//    }
    
	public boolean hasObj(int col, int row) {
		for(int i = 0; i < this.size; i++) {
    		if(this.list[i].getCol() == col && this.list[i].getRow() == row) {
    			return true;
    		}
    	}
		return false;
	}
	
	public int getVida(int col, int row) {
		for(int i = 0; i < this.size; i++) {
    		if(this.list[i].getCol() == col && this.list[i].getRow() == row) {
    			return this.list[i].getVida();
    		}
    	}
		return 0;
	}
	
	public boolean hurt(int col, int row, int damage) {
		for(int i = 0; i < this.size; i++) {
			if(list[i].getCol() == col && list[i].getRow() == row) {
				return list[i].damage(damage);
			}
		}
		return false;
	}
	
    public boolean run() {
    	for(int i = 0; i < this.size; i++) {
    		this.list[i].execute();
    	}
    	return true;
    }
    
    public boolean clear() {
		for(int i = 0; i < this.size; i++) {
    		if(list[i].getVida() <= 0) {
    			for(int j = i + 1; j < this.size; j++) {
    				list[j - 1] = list[j];
    	    	}
    			this.size--;
    			i--;
    		}
    	}
		return true;
	}
}
