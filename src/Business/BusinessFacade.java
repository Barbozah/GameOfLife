package Business;

import Persistence.CellNotInstantiatedException;
import Persistence.UserData;

/**
 * Classe fachada para acesso da simula��o e do jogador
 * @author Antonio
 */
public class BusinessFacade {
	
	private SimulationControl simCurrent;
	private UserData dataCurrent;
	private static BusinessFacade instance;
	
	/**
	 * Construtor privado para impedir mais de uma inst�ncia da classe
	 */
	private BusinessFacade(int rows, int columns, UserData data) {
		this.simCurrent = new Simulation(rows, columns);
		if(!data.getData().isEmpty()) {
			this.simCurrent.setCellControl(data.getData().get(data.getSelectedIndex()));
		}
		this.dataCurrent = data;
	}
	
	/**
	 * Retorna uma inst�ncia �nica da classe
	 * @return (inst�ncia �nica de Game)
	 */
	public static BusinessFacade getInstance() {
		if(BusinessFacade.instance == null) {
			BusinessFacade.instance = new BusinessFacade(100, 100, new UserData(new Player("anonymous", "anonymous")));
		}
		return BusinessFacade.instance;
	}
	
	/**
	 * 
	 * @param rows
	 * @param columns
	 */
	public static void setInstance(int rows, int columns, UserData data) {
		BusinessFacade.instance = new BusinessFacade(rows, columns, data);
	}
	
	/**
	 * Realiza uma muta��o atrav�s do comportamento do jogador 
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void action(int x, int y) throws CellNotInstantiatedException {
		simCurrent.mutation(x, y);
	}
	
	public void saveData() {
		dataCurrent.addData(simCurrent.getCellControl());
	}
	
	/**
	 * 
	 * @return
	 */
	public SimulationControl getSimCurrent() {
		return (SimulationControl) simCurrent;
	}
	
	/**
	 * 
	 * @return
	 */
	public UserData getDataCurrent() {
		return dataCurrent;
	}
}