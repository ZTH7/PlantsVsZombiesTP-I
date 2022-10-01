package tp1.p1.logic.gameobjects;


public class Sunflower extends Plants{
   public static int coste = 20;
    public static int resistencia = 1;
   public static int damage = 0;
    public static int frecuencia = 2;


    public Sunflower(int col, int row)
    {
    	this.vida = this.resistencia;
    	this.col = col;
    	this.row = row;
    	this.ciclo = game.CicloContador % this.frecuencia;
    }
    


    public static String getDescription() {
        return String.format(Messages.SUNFLOWER_DESCRIPTION, coste, damage, resistencia);
    }

    @Override
    public boolean execute() {

    	if(game.CicloContador % frecuencia == this.ciclo)
    	{
    		game.soles += 10;
    		return true;
    	}
        return false;
    }
}
