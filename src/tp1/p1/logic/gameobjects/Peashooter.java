package tp1.p1.logic.gameobjects;

public class Peashooter {
	String name = "P";
	public int coste = 50;
	public int resistencia = 3;
	public int damage = 1;
	public int frecuencia = 2;
	public int ciclo = 0;
	
	private int vida;
	private int col;
	private int row;
	
	public boolean dispara() {
		
		return true;
	}
	
	public boolean ciclo() {
		dispara();
		
		return true;
	}
	
	public Peashooter(int col, int row){
		this.vida = this.resistencia;
		this.col = col;
		this.row = row;
	}
	
	public static String getDescription() {
		String res = "[P]eashooter: cost='50' suncoins, damage='1', endurance='3'";
		
		return res;
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
