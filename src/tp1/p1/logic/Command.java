package tp1.p1.logic;

import tp1.p1.view.*;

public class Command {
	
	Game game;
	
	public Command(Game game){
		this.game = game;
	}
	
	public void Input(String[] input) {
		if(input[0].equalsIgnoreCase("a") || input[0].equalsIgnoreCase("add")) {
			if(input.length != 4) {
				System.out.printf(Messages.ERROR, "Missing parameters");
				return;
			}
			String name = input[1];
			int Col = Integer.parseInt(input[2]);
			int Row = Integer.parseInt(input[3]);
			add(name, Row, Col);
		}
		else if(input[0].equalsIgnoreCase("l") || input[0].equalsIgnoreCase("list")) {
			list();
		}
		else if(input[0].equalsIgnoreCase("r") || input[0].equalsIgnoreCase("reset")) {
			reset();
		}
		else if(input[0].equalsIgnoreCase("h") || input[0].equalsIgnoreCase("help")) {
			help();
		}
		else if(input[0].equalsIgnoreCase("e") || input[0].equalsIgnoreCase("exit")) {
			exit();
		}
		else if(input[0].equalsIgnoreCase("")) {
			none();
		}
		else {
			System.out.printf(Messages.ERROR, "Command ERROR");
		}
		
	}
	
	public void add(String name, int Col, int Row) {
		
	}
	
	public void list() {
		System.out.println(Messages.LIST);
	}
	
	public void reset() {
		this.game.CicloContador = 0;
		this.game.soles = 50;
		
		
		
	}
	
	public void help() {
		for(String str : Messages.HELP_LINES) {
			System.out.println(str);
		}
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void none() {
		game.update();
	}
}
