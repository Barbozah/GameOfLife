package Business;

/**
 * Classe principal que faz a relação entre o jogador e a simulação.
 * @author Antonio
 */
public class Game {
	
	private Simulation simCurrent;
	private Player simPlayer;
	
	public Game(Simulation simCurrent, Player simPlayer){
		setSimCurrent(simCurrent);
		setSimPlayer(simPlayer);
	}
	
	public void action(int x, int y) {
		simCurrent.mutation(simPlayer, x, y);
	}
	
	public Simulation getSimCurrent() {
		return simCurrent;
	}
	public void setSimCurrent(Simulation simCurrent) {
		this.simCurrent = simCurrent;
	}
	public Player getSimPlayer() {
		return simPlayer;
	}
	public void setSimPlayer(Player simPlayer) {
		this.simPlayer = simPlayer;
	}
}