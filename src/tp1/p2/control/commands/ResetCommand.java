package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ResetCommand extends Command {

	private Level level;

	private long seed;

	public ResetCommand() {
	}

	public ResetCommand(Level level, long seed) {
		this.level = level;
		this.seed = seed;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_RESET_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game){
		// TODO add your code here
		if(level != null) game.reset(level, seed);
		else game.reset();
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) {
		// TODO add your code here
		if(parameters.length != 0) {
			Level l = Level.valueOfIgnoreCase(parameters[0]);
			if (l == null) {
				System.out.println(error(Messages.INVALID_COMMAND));
				return null;
			}
			
			try {
				if (parameters.length == 2) {
					long s = Long.parseLong(parameters[1]);
					return new ResetCommand(l,s);
				}
			} catch (NumberFormatException nfe) {
				System.out.println(String.format(Messages.SEED_NOT_A_NUMBER_ERROR, parameters[1]));
				return null;
			}
		}
		
		return this;
	}

}
