package Persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que implementa o repositório de células em uma matriz
 * 
 * @author Antonio
 *
 */
public class CellGrid implements CellRepositoryControl {

	private static final long serialVersionUID = 1L;
	private Cell[][] grid;
	private List<Coordinate> assets;
	private int rows;
	private int columns;
	private int countIterator;
	private String date;

	public CellGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		assets = new ArrayList<>();
		setGrid(rows, columns);
		gridBoot();
		countIterator = 0;
		date = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date());
	}

	public CellGrid(Cell[][] grid) {
		this.rows = grid.length;
		this.columns = grid[0].length;
		assets = new ArrayList<>();
		setGrid(grid);
		countIterator = 0;
		date = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(new Date());
	}

	/**
	 * Define a matriz de células
	 * @param grid Matriz de células
	 */
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	/**
	 * Define a matriz de células com quantidade de linhas e colunas
	 * @param rows Quantidade de linhas
	 * @param columns Quantidade de colunas
	 */
	public void setGrid(int rows, int columns) {
		setGrid(new Cell[rows][columns]);
	}

	public Cell[][] getGrid() {
		return grid;
	}

	/**
	 * Inicializa a matriz de células
	 */
	private void gridBoot() {
		if (grid != null) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					grid[i][j] = new Cell();
				}
			}
		}
	}

	/**
	 * Procura uma célula na lista de células observadas
	 * @return As coordenadas da célula
	 * @throws CellNotInstantiatedException Caso a célula não foi encontrada
	 */
	public Coordinate searchAssets(int x, int y) throws CellNotInstantiatedException {
		for (Coordinate coord : assets) {
			if (coord.getX() == x && coord.getY() == y) {
				return coord;
			}
		}
		throw new CellNotInstantiatedException(x, y);
	}

	/**
	 * @return Lista de células observadas
	 */
	public List<Coordinate> assetsList() {
		return assets;
	}

	/**
	 * Adiciona uma célula na lista de observadas
	 * @throws CellNotInstantiatedException Caso a célula não for encontrada
	 */
	public void addAsset(int x, int y) throws CellNotInstantiatedException {
		for (int i = y - 1; i <= y + 1; i++) {
			for (int j = x - 1; j <= x + 1; j++) {
				if (i < 0 || j < 0 || i >= rows || j >= columns) {
					continue;
				}
				try {
					searchAssets(j, i);
				}catch (Exception e) {
					assets.add(new Coordinate(j, i));
				}
			}
		}
	}

	/**
	 * Remove uma célula da lista de observadas
	 * @throws CellNotInstantiatedException 
	 */
	public void removeAsset(int x, int y) throws CellNotInstantiatedException {
		assets.remove(searchAssets(x, y));
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
	public void addNeighbor(int x, int y) throws CellNotInstantiatedException {
		try {
			grid[y][x].addNeighbor();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CellNotInstantiatedException(x, y);
		}
	}

	@Override
	public void removeNeighbor(int x, int y) throws ArrayIndexOutOfBoundsException {
		grid[y][x].removeNeighbor();
	}

	@Override
	public void setNeighbors(int x, int y, int neighbors) throws ArrayIndexOutOfBoundsException {
		grid[y][x].setNeighbors(neighbors);
	}

	@Override
	public int getNeighbors(int x, int y) throws ArrayIndexOutOfBoundsException {
		return grid[y][x].getNeighbors();
	}

	@Override
	public void addCell(int x, int y) throws ArrayIndexOutOfBoundsException {
		grid[y][x] = new Cell();
	}

	@Override
	public void addCell(int x, int y, boolean alive, int neighbors) throws ArrayIndexOutOfBoundsException, CellNotInstantiatedException {
		if (alive) {
			addAsset(x, y);
		}
		grid[y][x] = new Cell(alive, neighbors);
	}

	@Override
	public void removeCell(int x, int y) throws ArrayIndexOutOfBoundsException, CellNotInstantiatedException {
		assets.remove(searchAssets(x, y));
		grid[y][x] = null;
	}

	@Override
	public void killCell(int x, int y) throws ArrayIndexOutOfBoundsException, CellNotInstantiatedException {
		assets.remove(searchAssets(x, y));
		grid[y][x].setAlive(false);
	}

	@Override
	public void liveCell(int x, int y) throws ArrayIndexOutOfBoundsException, CellNotInstantiatedException {
		addAsset(x, y);
		grid[y][x].setAlive(true);
	}

	@Override
	public boolean isAlive(int x, int y) throws ArrayIndexOutOfBoundsException {
		return grid[y][x].isAlive();
	}

	@Override
	public void setAlive(int x, int y, boolean alive) throws ArrayIndexOutOfBoundsException, CellNotInstantiatedException {
		if (alive) {
			liveCell(x, y);
		} else {
			killCell(x, y);
		}
	}

	@Override
	public void setDimention(int rows, int columns) {
		Cell[][] buffer = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i < this.rows && j < this.columns) {
					buffer[i][j] = new Cell(grid[i][j]);
				} else {
					buffer[i][j] = new Cell();
				}
			}
		}
		setGrid(buffer);
		this.rows = rows;
		this.columns = columns;
	}

	@Override
	public void setIdealDimention(int scale) {
		setDimention(750 / scale, 1100 / scale);
	}

	@Override
	public CellRepositoryControl specialInstance() {
		return new CellGrid(rows, columns);
	}

	@Override
	public boolean hasNext() {
		if (countIterator < assets.size()) {
			return true;
		} else {
			countIterator = 0;
			return false;
		}
	}

	@Override
	public Coordinate next() {
		return assets.get(countIterator++);

	}

	@Override
	public void resetIterator() {
		countIterator = 0;
	}

	@Override
	public String createdIn() {
		return date;
	}

}
