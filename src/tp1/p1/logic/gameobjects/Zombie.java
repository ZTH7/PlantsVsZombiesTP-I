package tp1.p1.logic.gameobjects;

public class Zombie {
	String name = "Z";
	private int vida;
	private int col;
	private int row;
	
	public Zombie(int col, int row){
		this.col = col;
		this.row = row;
	}
	
	
	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	public int getVida() {
		return vida;
	}
}
