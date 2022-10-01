package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Peashooter extends Plants{
  public  static int coste = 50;
   public  static int resistencia = 3;
   public static int damage = 1;
    public int frecuencia = 1;


    public Peashooter(int col, int row)
    {
    	this.vida = this.resistencia;
    	this.col = col;
    	this.row = row;
    }



    public static String getDescription() {
        return String.format(Messages.PEASHOOTER_DESCRIPTION, coste, damage, resistencia);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
