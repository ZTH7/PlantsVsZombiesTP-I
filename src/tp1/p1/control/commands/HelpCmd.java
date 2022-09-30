package tp1.p1.control.commands;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class HelpCmd extends Command {

    public HelpCmd(String[] input, Game game) {
        this.game = game;
        this.input = input;
    }


    @Override
    public boolean execute() {
        for(String str : Messages.HELP_LINES) {
            System.out.println(str);
        }
        return false;
    }
}
