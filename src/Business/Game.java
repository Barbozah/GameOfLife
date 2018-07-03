package Business;

import Business.DynamicGridSize.DynamicSimulationControl;
import Business.StaticGridSize.StaticSimulation;
import Business.StaticGridSize.StaticSimulationControl;

/**
 * Classe fachada para acesso da simulação e do jogador
 * @author Antonio
 */
public class Game {
	
	private SimulationControl simCurrent;
	private Player playerCurrent;
	private static Game instance;
	
	/**
	 * Construtor privado para impedir mais de uma instância da classe
	 */
	private Game() {
		this.simCurrent = new StaticSimulation(50, 50);
		this.playerCurrent = new Player();
	}
	
	/**
	 * Retorna uma instância única da classe
	 */
	public static Game getInstance() {
		if(Game.instance == null) {
			Game.instance = new Game();
		}
		return Game.instance;
	}
	
	/**
	 * Realiza uma mutação através do comportamento do jogador 
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
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