package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Sunflower extends Plants{
    static int coste;
    static int resistencia;
    static int damage;
    public int frecuencia;




    public static String getDescription() {
        return String.format(Messages.SUNFLOWER_DESCRIPTION, coste, damage, resistencia);
    }

    @Override
    public boolean execute() {



        return false;
    }
}
