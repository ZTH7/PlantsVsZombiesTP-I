package tp1.p1.logic.gameobjects;

public class Peashooter {
	int coste = 50;
	int resistencia = 3;
	int damage = 1;
	boolean ciclo = false;
	
	public boolean dispara() {
		
		return true;
	}
	
	public boolean ciclo() {
		dispara();
		
		return true;
	}
	
	public Peashooter(){
		
	}
	
	public static String getDescription() {
		return String.format("[P]eashooter: cost='&s' suncoins, damage='&s', endurance='&s', coste ='&s', resistencia = '&s',damage = '&s'");
	}
}
