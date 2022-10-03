package tp1.p1.control.commands;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public abstract class Command {
    Game game;
    String[] input;


    public static Command matchCmd(String[] input, Game game){

        if(input[0].equalsIgnoreCase("a") || input[0].equalsIgnoreCase("add")) {
            if(input.length != 4) {
                System.out.printf(Messages.ERROR, Messages.COMMAND_PARAMETERS_MISSING);
                return null;
            }
            return new AddCmd(input, game);
        }
        else if(input[0].equalsIgnoreCase("l") || input[0].equalsIgnoreCase("list")) {
            return new ListCmd(input, game);
        }
        else if(input[0].equalsIgnoreCase("r") || input[0].equalsIgnoreCase("reset")) {
            return new ResetCmd(input, game);
        }
        else if(input[0].equalsIgnoreCase("h") || input[0].equalsIgnoreCase("help")) {
            return new HelpCmd(input, game);
        }
        else if(input[0].equalsIgnoreCase("e") || input[0].equalsIgnoreCase("exit")) {
            return new ExitCmd(input, game);
        }
        else if(input[0].equalsIgnoreCase("")) {
            return new NoneCmd(input, game);
        }
        else {
            System.out.printf(Messages.ERROR, Messages.UNKNOWN_COMMAND);
        }

        return null;
    }

    public abstract boolean execute();

}
