package tp1.p1.logic.gameobjects;



public class Sunflower {
	int coste = 20;
	int resistencia = 1;
	int damage = 0;
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
}
