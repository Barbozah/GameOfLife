package Business;

public class Cellgrid implements CellControl {
	
	private Cell[][] grid;
	private int rows;
	private int columns;
	
	public Cellgrid(int rows, int columns) {
		setRows(rows);
		setColumns(columns);
		setGrid(rows, columns);
		gridBoot();
	}
	
	public Cellgrid(Cell[][] grid) {
		setRows(grid.length);
		setColumns(grid[0].length);
		setGrid(grid);
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	public void setGrid(int rows, int columns) {
		setGrid(new Cell[rows][columns]);
	}
	
	public Cell[][] getGrid() {
		return grid;
	}
	
	public void gridBoot() {
		if(grid != null) {
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {
					grid[i][j] = new Cell();
				}
			}
		}
	}
	
	public int getRows() {
		return rows;
	}

	private void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	private void setColumns(int columns) {
		this.columns = columns;
	}
	
	@Override
	public void addNeighbor(int x, int y) {
		try{
			grid[y][x].addNeighbor();
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
		}
	}

	@Override
	public void removeNeighbor(int x, int y) {
		try {
			grid[y][x].removeNeighbor();
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
		}
	}

	@Override
	public void setNeighbors(int x, int y, int neighbors) {
		try {	
			grid[y][x].setNeighbors(neighbors);
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
		}
	}

	@Override
	public int getNeighbors(int x, int y) {
		try {
			return grid[y][x].getNeighbors();
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
			return 0;
		}
	}

	@Override
	public void addCell(int x, int y) {
		grid[y][x] = new Cell();
	}
	
	public void addCell(int x, int y, boolean alive, int neighbors) {
		grid[y][x] = new Cell(alive, neighbors);
	}
	
	@Override
	public void removeCell(int x, int y) {
		grid[y][x] = null;
	}

	@Override
	public void killCell(int x, int y) {
		try {
			grid[y][x].setAlive(false);
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
		}
	}

	@Override
	public void liveCell(int x, int y) {
		try {
			grid[y][x].setAlive(true);
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
		}
	}

	@Override
	public boolean isAlive(int x, int y) {
		try {
			return grid[y][x].isAlive();
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
			return false;
		}
	}

	@Override
	public void setAlive(int x, int y, boolean alive) {
		try {
			grid[y][x].setAlive(alive);;
		}catch (NullPointerException e) {
			System.err.println("Error: Cell["+ y +"][" + x + "] is null");
		}
	}

}
