package tp1.p1.logic.gameobjects;

public class Peashooter {
	String name = "P";
	public static int coste = 50;
	public static int resistencia = 3;
	public static int damage = 1;
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
		return String.format("[P]eashooter: cost='%s' suncoins, damage='%s', endurance='%s'", coste, damage, resistencia);

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
