package tp1.p2.logic;

public interface GameStatus {

	int getCycle();

	int getSuncoins();

	// TODO add your code here
	String positionToString(int col, int row);
	
	boolean isFinished();
	
	boolean isPlayerQuits();
	
	boolean isZombieWins();
	
	int getRemainingZombies();
}
