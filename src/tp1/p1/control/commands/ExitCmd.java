package tp1.p1.control.commands;

import tp1.p1.logic.Game;

public class ExitCmd extends Command {
    public ExitCmd(String[] input, Game game) {
        this.game = game;
        this.input = input;
    }


    @Override
    public boolean execute() {
        game.playerExit();
        return true;
    }
}
