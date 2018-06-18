package Business;

/**
 * Classe representativa de cada célula do automato.
 * @author Antonio
 */
public class Cell {
	
	private boolean alive;
	private int neighbors;
	
	public Cell() {
		setAlive(false);
		setNeighbors(0);
	}
	
	public Cell(boolean alive, int neighbors) {
		setAlive(alive);
		setNeighbors(neighbors);
	}
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void addNeighbor() {
		neighbors++;
	}
	
	public void removeNeighbor() {
		neighbors--;
	}
	
	public int getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}
}
