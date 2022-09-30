package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Peashooter extends Plants{
    static int coste;
    static int resistencia;
    static int damage;
    public int frecuencia;





    public static String getDescription() {
        return String.format(Messages.PEASHOOTER_DESCRIPTION, coste, damage, resistencia);
    }

    @Override
    public boolean execute() {
        return false;
    }
}
