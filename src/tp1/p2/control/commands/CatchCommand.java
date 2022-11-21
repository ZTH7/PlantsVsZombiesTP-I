package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class CatchCommand extends Command {

	private static boolean caughtSunThisCycle = false;

	private int col;

	private int row;

	public CatchCommand() {
		caughtSunThisCycle = false;
	}
	
	@Override
	protected void newCycleStarted() {
		caughtSunThisCycle = false;
	}

	private CatchCommand(int col, int row) {
		this.col = col;
		this.row = row;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_CATCH_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_CATCH_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_CATCH_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_CATCH_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		if(!caughtSunThisCycle && game.tryToCatchObject(col, row)) {
			caughtSunThisCycle = true;
			return new ExecutionResult(true);
		}
		return new ExecutionResult(error(Messages.SUN_ALREADY_CAUGHT));
	}

	@Override
	public Command create(String[] parameters) {
		if(parameters.length < 2) {
			System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
            return null;
		}
		
		try {
    		col = Integer.parseInt(parameters[0]);
    		row = Integer.parseInt(parameters[1]);
    	}
    	catch(Exception e) {
    		System.out.println(error(Messages.INVALID_POSITION));
    		return null;
    	}
		
		return new CatchCommand(col, row);
	}

}
