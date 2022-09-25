package tp1.p1.logic.gameobjects;



public class Sunflower {
	static int coste = 20;
	static int resistencia = 1;
	static int damage = 0;
	boolean ciclo = false;
	
	public Sunflower(){
		
	}
	
	public boolean GeneraSol() {
		
		return true;
	}
	
	public boolean ciclo() {
		if(ciclo) {
			GeneraSol();
			ciclo = false;
		} else ciclo = true;
		
		return true;
	}
	
	public static String getDescription() {
		return String.format("[S]unflower: cost='%s' suncoins, damage='%s', endurance='%s'", coste, damage, resistencia);
		
	}
}
