package tp1.p2.control.commands;

//import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ResetCommand extends Command {

	private Level level;

	private long seed = 0;

	public ResetCommand() {
		super(false);
	}

	public ResetCommand(Level level, long seed) {
		super(false);
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
		game.Reset(level, seed);
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) {
		// TODO add your code here
		if(parameters.length == 0) return new ResetCommand();
		
		Level level = Level.valueOfIgnoreCase(parameters[0]);
		if (level == null) {
			System.out.println(Messages.ALLOWED_LEVELS);
			return null;
		}
		
		try {
			if (parameters.length == 2) seed = Long.parseLong(parameters[1]);
		} catch (NumberFormatException nfe) {
			System.out.println(String.format(Messages.SEED_NOT_A_NUMBER_ERROR, parameters[1]));
			return null;
		}
		
		return this;
	}

}
