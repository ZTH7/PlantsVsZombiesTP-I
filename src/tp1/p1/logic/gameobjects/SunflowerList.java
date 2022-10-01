package tp1.p1.logic.gameobjects;

public class SunflowerList extends PlantsList{

	public SunflowerList(int num_col, int num_row)
	{
		this.list = new Sunflower[num_col*num_row];
	}
	
    public boolean add(int col, int row) {
        Sunflower sunflower = new Sunflower(col,row);
        
        
        this.list[size] = sunflower;
        this.size++;

        return false;
    }

	
	
	public SunflowerList(){
		
	}
}
