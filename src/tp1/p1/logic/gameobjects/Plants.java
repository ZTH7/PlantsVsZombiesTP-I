package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public abstract class Plants {
    //Atributo fijo
    Game game;

    //Atributo cambiable
    public int ciclo;
    private int vida;
    private int col;
    private int row;


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getVida() {
        return vida;
    }


    public abstract boolean execute();
}
