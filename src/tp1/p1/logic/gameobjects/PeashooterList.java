package tp1.p1.logic.gameobjects;

public class PeashooterList {

	public PeashooterList(int num_col, int num_row)
	{
		this.list = new Peashooter[num_col*num_row];
	}
	

    @Override
    public boolean add(int col, int row) {
    	Peashooter peashooter = new Peashooter(col,row);
        return false;
    }
}
