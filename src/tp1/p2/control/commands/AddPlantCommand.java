package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCommand extends Command implements Cloneable {

	private int col;

	private int row;

	private String plantName;

	private boolean consumeCoins;

	public AddPlantCommand() {
		this(true);
	}

	public AddPlantCommand(boolean consumeCoins) {
		this.consumeCoins = consumeCoins;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_HELP;
	}


	@Override
	public ExecutionResult execute(GameWorld game) {
		// TODO add your code here
		if(!PlantFactory.isValidPlant(plantName)) return new ExecutionResult(error(Messages.INVALID_GAME_OBJECT));

		if(col < 0 || col >= GameWorld.NUM_COLS || row < 0 || row >= GameWorld.NUM_ROWS) {
    		return new ExecutionResult(error(Messages.INVALID_POSITION));
    	}
		
		if(game.getGameItemInPosition(col, row) == null) {
			Plant plant = PlantFactory.spawnPlant(plantName, game, col, row);
			if(plant != null) {
				if(!consumeCoins || game.addSunCoin(-plant.getCost())) {
					game.addItem(plant);
					game.update();
				}
				else return new ExecutionResult(error(Messages.NOT_ENOUGH_COINS));
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
    		plantName = parameters[0];
    		col = Integer.parseInt(parameters[1]);
    		row = Integer.parseInt(parameters[2]);
    	}
    	catch(Exception e) {
    		System.out.println(error(Messages.INVALID_POSITION));
    		return null;
    	}
		
		return this;
	}

}


