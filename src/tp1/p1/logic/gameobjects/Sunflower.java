package tp1.p1.logic.gameobjects;



public class Sunflower {
	String name = "S";
	static int coste = 20;
	static int resistencia = 1;
	static int damage = 0;
	public int frecuencia = 1;
	public int ciclo = 0;
	
	private int vida;
	private int col;
	private int row;
	
	public Sunflower(){
		
	}
	
	public boolean GeneraSol() {
		
		return true;
	}
	
	public boolean ciclo() {
		if(ciclo >= frecuencia) {
			GeneraSol();
			ciclo = 0;
		} else ciclo++;
		
		return true;
	}
	
	public static String getDescription() {
		return String.format("[S]unflower: cost='%s' suncoins, damage='%s', endurance='%s'", coste, damage, resistencia);
		
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
