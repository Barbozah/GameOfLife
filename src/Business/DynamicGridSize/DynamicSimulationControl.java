package Business.DynamicGridSize;

import Business.SimulationControl;

/**
 * Interface que extende os métodos de manipulação de uma simulação
 * @author Antonio
 *
 */

public interface DynamicSimulationControl extends SimulationControl{
	
	public DynamicCellControl getCellControl();
	public void setCellControl(DynamicCellControl cellControl);
	
}
