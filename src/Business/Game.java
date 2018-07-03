package Business;

import Business.DynamicGridSize.DynamicSimulationControl;
import Business.StaticGridSize.StaticSimulation;
import Business.StaticGridSize.StaticSimulationControl;

/**
 * Classe fachada para acesso da simula��o e do jogador
 * @author Antonio
 */
public class Game {
	
	private SimulationControl simCurrent;
	private Player playerCurrent;
	private static Game instance;
	
	/**
	 * Construtor privado para impedir mais de uma inst�ncia da classe
	 */
	private Game() {
		this.simCurrent = new StaticSimulation(50, 50);
		this.playerCurrent = new Player();
	}
	
	/**
	 * Retorna uma inst�ncia �nica da classe
	 */
	public static Game getInstance() {
		if(Game.instance == null) {
			Game.instance = new Game();
		}
		return Game.instance;
	}
	
	/**
	 * Realiza uma muta��o atrav�s do comportamento do jogador 
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @throws CellNotInstantiatedException
	 */
	public void action(int x, int y) throws CellNotInstantiatedException{
		simCurrent.mutation(playerCurrent.getCursorBehavior(), x, y);
	}
	
	public DynamicSimulationControl getSimCurrent() {
		return (DynamicSimulationControl) simCurrent;
	}
	
	public StaticSimulationControl getStaticSimulation() {
		return (StaticSimulationControl) simCurrent;
	}
	
	public Player getPlayerCurrent() {
		return playerCurrent;
	}
}