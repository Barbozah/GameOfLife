package Business.StaticGridSize;

import Business.SimulationControl;

public interface StaticSimulationControl extends SimulationControl {
	
	public StaticCellControl getCellControl();
	public void setCellControl(StaticCellControl cellControl);
	
}
