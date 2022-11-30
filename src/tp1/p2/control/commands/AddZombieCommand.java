package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

public class AddZombieCommand extends Command {

	private int zombieIdx;

	private int col;

	private int row;

	public AddZombieCommand() {

	}

	private AddZombieCommand(int zombieIdx, int col, int row) {
		this.zombieIdx = zombieIdx;
		this.col = col;
		this.row = row;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_ZOMBIE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_ZOMBIE_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_ZOMBIE_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		// TODO add your code here
		if(!ZombieFactory.isValidZombie(zombieIdx)) return new ExecutionResult(error(Messages.INVALID_GAME_OBJECT));

		if(col < 0 || col > GameWorld.NUM_COLS || row < 0 || row >= GameWorld.NUM_ROWS) {
    		return new ExecutionResult(error(Messages.INVALID_POSITION));
    	}
		
		if(game.getGameItemInPosition(col, row) == null) {
			Zombie zombie = ZombieFactory.spawnZombie(zombieIdx, game, col, row);
			if(zombie != null) {
				game.addItem(zombie);
				game.update();
			}
			else return new ExecutionResult(error(Messages.INVALID_GAME_OBJECT));
		}
		else return new ExecutionResult(error(Messages.INVALID_POSITION));
		
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) {
		// TODO add your code here
		if(parameters.length < 3) {
			System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
            return null;
		}
		
		try {
			zombieIdx = Integer.parseInt(parameters[0]);
    		col = Integer.parseInt(parameters[1]);
    		row = Integer.parseInt(parameters[2]);
    	}
    	catch(Exception e) {
    		System.out.println(error(Messages.INVALID_POSITION));
    		return null;
    	}
		
		return new AddZombieCommand(zombieIdx, col, row);
	}

}
