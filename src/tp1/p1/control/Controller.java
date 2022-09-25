package tp1.p1.control;

import java.util.Random;
import java.util.Scanner;

import tp1.p1.logic.Game;
import tp1.p1.view.GamePrinter;
import tp1.p1.view.Messages;
import tp1.p1.logic.*;

/**
 * Accepts user input and coordinates the game execution logic.
 *
 */
public class Controller {

	private Game game;

	private Scanner scanner;

	private GamePrinter gamePrinter;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(game);
	}

	/**
	 * Draw / Paint the game.
	 */
	private void printGame() {
		System.out.println(gamePrinter);
	}

	/**
	 * Prints the final message once the match is finished.
	 */
	public void printEndMessage() {
		System.out.println(gamePrinter.endMessage());
	}

	/**
	 * Show prompt and request command.
	 *
	 * @return the player command as words
	 */
	private String[] prompt() {
		System.out.print(Messages.PROMPT);
		String line = scanner.nextLine();
		String[] words = line.toLowerCase().trim().split("\\s+");

		System.out.println(debug(line));

		return words;
	}

	/**
	 * Runs the game logic.
	 */
	
	String debug(String line) {
		return Messages.debug(line);
	}
	
	public void run() {
		// TODO fill your code
		Random rand = new Random(game.seed);
		Command command = new Command(game);
		boolean GameOver = false;
		ZombiesManager zombManag = new ZombiesManager(game, game.level, rand);
		String[] input;
		
		while(!GameOver) {
			
			input = prompt();
			
			command.Input(input);
			
			if(game.update) {
				
				System.out.println("Remaining zombies: " + zombManag.getRemainingZombies());
				
				printGame();
				game.update = false;

				game.CicloContador++;
			}
			
		}
		
		
		
		
		
		gamePrinter.endMessage();
	}
}
