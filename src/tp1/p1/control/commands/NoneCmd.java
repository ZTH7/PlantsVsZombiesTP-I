package tp1.p1.control.commands;

import tp1.p1.logic.Game;

public class NoneCmd extends Command {

    public NoneCmd(String[] input, Game game) {
        this.game = game;
        this.input = input;
    }


    @Override
    public boolean execute() {
        return true;
    }
}
