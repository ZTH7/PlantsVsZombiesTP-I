package tp1.p1.logic.gameobjects;



public class Sunflower {
	String name = "S";
	int coste = 20;
	int resistencia = 1;
	int damage = 0;
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
		String res = "";
		
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
