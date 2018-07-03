package Business.DynamicGridSize;

import Business.SimulationControl;

/**
 * Interface que extende os m�todos de manipula��o de uma simula��o
 * @author Antonio
 *
 */

public interface DynamicSimulationControl extends SimulationControl{
	
	public DynamicCellControl getCellControl();
	public void setCellControl(DynamicCellControl cellControl);
	
}
