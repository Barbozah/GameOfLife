package Business;

import Persistence.CellRepositoryControl;
import Persistence.CellGrid;
import Persistence.CellNotInstantiatedException;
import Persistence.Coordinate;

public class Simulation implements SimulationControl {

	private Stopwatch runtime;
	private boolean paused = true;
	private long velocity;
	private int generation;
	private boolean behavior;
	private CellRepositoryControl cellControl;
	private CellRepositoryControl bufferControl;
	
	public Simulation(int rows, int columns) {
		runtime = new Stopwatch();
		setVelocity(SimulationControl.MAX_VELOCITY);
		generation = 0;
		setCellControl(new CellGrid(rows, columns));
	}
	
	@Override
	public void mutation(int x, int y) throws CellNotInstantiatedException {
		cellControl.setAlive(x, y, behavior);
	}

	@Override
	public void update(int x, int y) throws CellNotInstantiatedException {
		for(int i=y-1;i<=y+1;i++) {
			for(int j=x-1;j<=x+1;j++) {
				if(i==y && j==x) {
					continue;
				}
				try{
					if(cellControl.isAlive(j, i)) {
						cellControl.addNeighbor(x, y);
					}
				}catch (Exception e) {
					continue;
				}
			}
		}
		int neighbors = 0;
		boolean isAlive = false;
		try {
			neighbors = cellControl.getNeighbors(x, y);
			isAlive = cellControl.isAlive(x, y);
		}catch (Exception e) {}
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
		bufferControl = cellControl.specialInstance();
		cellControl.resetIterator();
		while(cellControl.hasNext()) {
			Coordinate c = cellControl.next();
			update(c.getX(), c.getY());
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
	public CellRepositoryControl getCellControl() {
		return cellControl;
	}

	@Override
	public void setCellControl(CellRepositoryControl cellControl) {
		this.cellControl = cellControl;
	}

	@Override
	public boolean isPaused() {
		return paused;
	}

	@Override
	public void pause() {
		paused = true;
		
	}

	@Override
	public void play() {
		paused = false;
	}

	@Override
	public boolean getCursorBehavior() {
		return behavior;
	}

	@Override
	public void setCursorBehavior(boolean behavior) {
		this.behavior = behavior;
	}

}
