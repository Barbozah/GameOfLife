package Business.StaticGridSize;

import Business.Cell;
import Business.CellNotInstantiatedException;

/**
 * Classe que implementa o controle estático de células
 * @author Antonio
 *
 */
public class CellStaticGrid implements StaticCellControl {
	
	private Cell[][] grid;
	private int rows;
	private int columns;
	
	public CellStaticGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		setGrid(rows, columns);
		gridBoot();
	}
	
	public CellStaticGrid(Cell[][] grid) {
		this.rows = grid.length;
		this.columns = grid[0].length;
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
	
	/**
	 * Inicializa a matriz de células
	 */
	public void gridBoot() {
		if(grid != null) {
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {
					grid[i][j] = new Cell();
				}
			}
		}
	}
	
	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public int getColumns() {
		return columns;
	}
	
	@Override
	public void addNeighbor(int x, int y) throws CellNotInstantiatedException{
		try{
			grid[y][x].addNeighbor();
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public void removeNeighbor(int x, int y) throws CellNotInstantiatedException{
		try {
			grid[y][x].removeNeighbor();
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public void setNeighbors(int x, int y, int neighbors) throws CellNotInstantiatedException{
		try {	
			grid[y][x].setNeighbors(neighbors);
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public int getNeighbors(int x, int y) throws CellNotInstantiatedException{
		try {
			return grid[y][x].getNeighbors();
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
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
	public void removeCell(int x, int y) throws CellNotInstantiatedException{
		grid[y][x] = null;
	}

	@Override
	public void killCell(int x, int y) throws CellNotInstantiatedException{
		try {
			grid[y][x].setAlive(false);
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public void liveCell(int x, int y) throws CellNotInstantiatedException{
		try {
			grid[y][x].setAlive(true);
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public boolean isAlive(int x, int y) throws CellNotInstantiatedException{
		try {
			return grid[y][x].isAlive();
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public void setAlive(int x, int y, boolean alive) throws CellNotInstantiatedException{
		try {
			grid[y][x].setAlive(alive);
		}catch (NullPointerException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}
	
}
