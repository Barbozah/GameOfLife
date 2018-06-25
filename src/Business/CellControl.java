package Business;

public interface CellControl {
	public int getRows();
	public int getColumns();
	public void addNeighbor(int x, int y);
	public void removeNeighbor(int x, int y);
	public void setNeighbors(int x, int y, int neighbors);
	public int getNeighbors(int x, int y);
	public void addCell(int x, int y);
	public void addCell(int x, int y, boolean alive, int neighbors);
	public void removeCell(int x, int y);
	public void killCell(int x, int y);
	public void liveCell(int x, int y);
	public void setAlive(int x, int y, boolean alive);
	public boolean isAlive(int x, int y);
}
