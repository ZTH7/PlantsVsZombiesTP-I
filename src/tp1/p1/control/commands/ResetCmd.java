package tp1.p1.control.commands;

import tp1.p1.logic.Game;

public class ResetCmd extends Command {

    public ResetCmd(String[] input, Game game) {
        this.game = game;
        this.input = input;
    }


    @Override
    public boolean execute() {
    	game.Reset();
        return false;
    }
}
