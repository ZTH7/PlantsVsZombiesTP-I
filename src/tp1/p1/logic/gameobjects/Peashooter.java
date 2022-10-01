package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;
import tp1.p1.logic.*;

public class Peashooter extends Plants{
    public static int coste = 50;
    public static int resistencia = 3;
    public static int damage = 1;
    public static int frecuencia = 1;

    public Peashooter(int col, int row, Game game) {
    	this.vida = Peashooter.resistencia;
    	this.col = col;
    	this.row = row;
    	this.game = game;
    	this.ciclo = game.CicloContador % Sunflower.frecuencia;
    }



    public static String getDescription() {
        return String.format(Messages.PEASHOOTER_DESCRIPTION, coste, damage, resistencia);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
