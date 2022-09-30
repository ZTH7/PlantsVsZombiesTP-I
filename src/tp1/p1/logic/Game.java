package tp1.p1.logic;

import java.util.Random;
import tp1.p1.control.Level;
import tp1.p1.logic.gameobjects.*;

public class Game {

    public int CicloContador = 0;
    public int soles = 50;
    public static int NUM_COLS = 8;
    public static int NUM_ROWS = 4;

    public ZombiesManager zombiesManager;
    private Random rand;

    public Game(long seed, Level level){
        rand = new Random(seed);
        zombiesManager = new ZombiesManager(this, level, rand);
    }

    public boolean update() {


        CicloContador++;

        return true;
    }

    public String positionToString(int col, int row) {
        String res = "";




        return res;
    }
}
