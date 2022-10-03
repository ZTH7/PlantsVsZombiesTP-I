package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;
import tp1.p1.logic.*;

public class Sunflower extends Plants{
    public static int coste = 20;
    public static int resistencia = 1;
    public static int damage = 0;
    public static int frecuencia = 2;

    public Sunflower(int col, int row, Game game) {
    	this.vida = Sunflower.resistencia;
    	this.col = col;
    	this.row = row;
    	this.game = game;
    	
    	this.ciclo = game.CicloContador % Sunflower.frecuencia;
    }


    public static String getDescription() {
        return String.format(Messages.SUNFLOWER_DESCRIPTION, coste, damage, resistencia);
    }

    @Override
    public boolean execute() {

    	if(game.CicloContador % frecuencia == this.ciclo) {
    		game.soles += 10;
    		return true;
    	}

        return false;
    }
}
