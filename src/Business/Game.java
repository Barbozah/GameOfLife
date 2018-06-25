package Business;

/**
 * Classe principal que faz a relação entre o jogador e a simulação.
 * @author Antonio
 */
public class Game {
	
	private Simulation simCurrent;
	private Player playerCurrent;
	private static Game instance;
	
	public Game() {
		this.simCurrent = new SimpleSimulation(50, 50);
		this.playerCurrent = new Player();
	}
	
	public static Game getInstance() {
		if(Game.instance == null) {
			Game.instance = new Game();
		}
		return Game.instance;
	}
	
	public void action(int x, int y) {
		simCurrent.mutation(playerCurrent.getCursorBehavior(), x, y);
	}
	
	public Simulation getSimCurrent() {
		return simCurrent;
	}
	
	public Player getPlayerCurrent() {
		return playerCurrent;
	}
}