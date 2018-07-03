package Business.DynamicGridSize;

import java.util.ArrayList;

import Business.CellNotInstantiatedException;

/**
 * Classe que implementa o controle dinâmico de células
 * @author Antonio
 *
 */
public class CellDynamicGrid implements DynamicCellControl {

	private ArrayList<CellVirtual> grid;
	
	public CellDynamicGrid() {
		grid = new ArrayList<>();
	}
	
	@Override
	public CellVirtual getCell(int x, int y) {
		for (CellVirtual cellVirtual : grid) {
			if(cellVirtual.getX() == x && cellVirtual.getY() == y) {
				return cellVirtual;
			}
		}
		CellVirtual c = new CellVirtual(x, y);
		grid.add(c);
		return c;
	}
	
	@Override
	public CellVirtual getCell(int staticIndex) throws CellNotInstantiatedException{
		if(staticIndex < 0 || staticIndex > grid.size()) {
			throw new CellNotInstantiatedException(staticIndex);
		}else if(staticIndex == grid.size()) {
			grid.add(new CellVirtual());
		}
		return grid.get(staticIndex);
	}
	
	@Override
	public void addNeighbor(int x, int y) {
		getCell(x, y).addNeighbor();
	}

	@Override
	public void removeNeighbor(int x, int y) {
		getCell(x, y).removeNeighbor();
	}

	@Override
	public void setNeighbors(int x, int y, int neighbors) {
		getCell(x, y).setNeighbors(neighbors);
	}

	@Override
	public int getNeighbors(int x, int y) {
		return getCell(x, y).getNeighbors();
	}

	@Override
	public void addCell(int x, int y) {
		grid.add(new CellVirtual(x, y));
	}

	@Override
	public void addCell(int x, int y, boolean alive, int neighbors) {
		grid.add(new CellVirtual(x, y, alive, neighbors));
	}

	@Override
	public void removeCell(int x, int y) {
		grid.remove(getCell(x, y));
	}

	@Override
	public void killCell(int x, int y) {
		getCell(x, y).setAlive(false);
	}

	@Override
	public void liveCell(int x, int y) {
		getCell(x, y).setAlive(true);
	}

	@Override
	public void setAlive(int x, int y, boolean alive) {
		getCell(x, y).setAlive(alive);
	}

	@Override
	public boolean isAlive(int x, int y) {
		return getCell(x, y).isAlive();
	}

	@Override
	public int length() {
		return grid.size();
	}

}
