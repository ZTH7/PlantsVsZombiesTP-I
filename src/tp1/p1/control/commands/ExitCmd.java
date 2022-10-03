package tp1.p1.control.commands;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class ExitCmd extends Command {
    public ExitCmd(String[] input, Game game) {
        this.game = game;
        this.input = input;
    }


    @Override
    public boolean execute() {
        System.out.println(Messages.PLAYER_QUITS);
        System.exit(0);
        return true;
    }
}
