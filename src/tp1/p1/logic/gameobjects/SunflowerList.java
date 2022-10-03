package tp1.p1.logic.gameobjects;

import tp1.p1.logic.*;

public class SunflowerList extends PlantsList{

	public SunflowerList(int num_col, int num_row) {
		this.list = new Sunflower[num_col*num_row];
	}
	
	
    @Override
    public boolean add(int col, int row, Game game) {
        Sunflower sunflower = new Sunflower(col, row, game);
        
        
        this.list[size] = sunflower;
        this.size++;

        return true;
    }

}
