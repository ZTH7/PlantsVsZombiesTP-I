package tp1.p1.control.commands;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;
import tp1.p1.logic.gameobjects.*;

public class AddCmd extends Command {
    public AddCmd(String[] input, Game game) {
        this.game = game;
        this.input = input;
    }

    @Override
    public boolean execute() {
    	String name;
    	int col;
    	int row;
    	try {
    		name = input[1];
    		col = Integer.parseInt(input[2]);
    		row = Integer.parseInt(input[3]);
    	}
    	catch(Exception e) {
    		System.out.println(String.format(Messages.ERROR, Messages.WRONG_PARAMETER));
    		return false;
    	}
    	
    	if(col < 0 || col >= game.NUM_COLS || row < 0 || row >= game.NUM_ROWS) {
    		
    		System.out.println(String.format(Messages.ERROR, Messages.WRONG_PARAMETER));
    		return false;
    	}
    				
    			
    					 
    			
    	
    	if(game.PList.get(col, row) == null &&
    			game.SList.get(col, row) == null && 
    			game.zombiesManager.get(col, row) == null) {
    		
    		if(name.equalsIgnoreCase("sunflower") || name.equalsIgnoreCase("s")) {
    			if(game.soles >= Sunflower.coste) {
    				game.SList.add(col, row, game);
    			}
    			else {
    				System.out.println(Messages.NOT_ENOUGH_COINS);
    				return false;
    			}
    			
    		}
    		else if(name.equalsIgnoreCase("peashooter") || name.equalsIgnoreCase("p")) {
    			if(game.soles >= Peashooter.coste) {
    				game.PList.add(col, row, game);
    			}
    			else {
    				System.out.println(Messages.NOT_ENOUGH_COINS);
    				return false;
    			}
    		}
    		else {
    			System.out.println(String.format(Messages.ERROR, Messages.WRONG_PARAMETER));
    			return false;
    		}
    	}
    	else {
    		System.out.println(String.format(Messages.ERROR, Messages.WRONG_PARAMETER));
			return false;
    	}
    	
    	
        return true;
    }
}
