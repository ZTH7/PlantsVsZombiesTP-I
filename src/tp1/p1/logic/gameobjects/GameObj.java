package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public abstract class GameObj {
    //Atributo fijo
    protected Game game;

    //Atributo cambiable
    protected int ciclo;
    protected int vida;
    protected int col;
    protected int row;


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getVida() {
        return vida;
    }
    
    public boolean damage(int val) {
    	if(this.vida > 0) {
    		this.vida -= val;
    		return true;
    	}
    	return false;
    }
    
    public abstract boolean execute();
}
