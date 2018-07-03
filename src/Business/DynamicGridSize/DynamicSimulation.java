package Business.DynamicGridSize;

import Business.CellNotInstantiatedException;
import Business.SimulationControl;
import Business.Stopwatch;

public class DynamicSimulation implements DynamicSimulationControl{
	
	private Stopwatch runtime;
	private long velocity;
	private int generation;
	private DynamicCellControl cellControl;
	private DynamicCellControl bufferControl;
	
	public DynamicSimulation() {
		runtime = new Stopwatch();
		setVelocity(SimulationControl.MAX_VELOCITY);
		generation = 0;
		setCellControl(new CellDynamicGrid());
	}

	@Override
	public void mutation(boolean behavior, int x, int y) throws CellNotInstantiatedException {
		cellControl.getCell(x, y).setAlive(behavior);
	}

	@Override
	public void update(int x, int y) throws CellNotInstantiatedException {
		for(int i=y-1;i<=y+1;i++) {
			for(int j=x-1;j<=x+1;j++) {	
				if(cellControl.getCell(j, i).isAlive()) {
					cellControl.getCell(x, y).addNeighbor();
				}
			}	
		}
		
		int neighbors = cellControl.getNeighbors(x, y);
		boolean isAlive = cellControl.isAlive(x, y);
		boolean alive = false;
		
		if(neighbors > 3 || neighbors < 2) {
			alive = false;
		}
		
		if(isAlive == false && neighbors == 3) {
			alive = true;
		}
		
		if(isAlive && ((neighbors == 2 )||(neighbors == 3))) {
			alive = isAlive;
		}
		
		bufferControl.addCell(x, y, alive, 0);
	}

	@Override
	public void selection() throws CellNotInstantiatedException {
		bufferControl = new CellDynamicGrid();
		for(int i=0;i<cellControl.length();i++) {
			update(cellControl.getCell(i).getX(), cellControl.getCell(i).getY());
		}
		generation++;
		setCellControl(bufferControl);
	}

	@Override
	public long getVelocity() {
		return velocity;
	}

	@Override
	public void setVelocity(long velocity) {
		this.velocity = velocity;
	}

	@Override
	public int getGeneration() {
		return generation;
	}

	@Override
	public Stopwatch getRuntime() {
		return runtime;
	}

	@Override
	public DynamicCellControl getCellControl() {
		return cellControl;
	}

	@Override
	public void setCellControl(DynamicCellControl cellControl) {
		this.cellControl = cellControl;
	}

}
