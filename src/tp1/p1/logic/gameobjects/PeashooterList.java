package tp1.p1.logic.gameobjects;

import tp1.p1.logic.*;

public class PeashooterList extends GameObjList{

	public PeashooterList(int num_col, int num_row) {
		this.list = new Peashooter[num_col*num_row];
	}

    @Override
    public boolean add(int col, int row, Game game) {
    	Peashooter peashooter = new Peashooter(col, row, game);
    	
        this.list[size] = peashooter;
        this.size++;
        return true;
    }
}
