package tp1.p1.logic.gameobjects;

public abstract class PlantsList {
	public Plants[] list;
	public int size = 0;

    public abstract boolean add(int col, int row);
    
    public boolean remove(int col, int row) {
    	for(int i = 0; i < this.size; i++) {
    		if(this.list[i].getCol() == col && this.list[i].getRow() == row) {
    			for(int j = i + 1; j < this.size; j++) {
    				this.list[j - 1] = this.list[j];
    			}
    			this.size--;
    			return true;
    		}
    	}
    	return false;
    }
    
    public Plants get(int col, int row) {
    	for(int i = 0; i < this.size; i++) {
    		if(this.list[i].getCol() == col && this.list[i].getRow() == row) {
    			return this.list[i];
    		}
    	}
    	return null;
    }
}
