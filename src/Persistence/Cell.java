package Persistence;

import java.io.Serializable;

/**
 * Classe representativa de cada c�lula do automato.
 * @author Antonio
 */
public class Cell implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private boolean alive;
	private int neighbors;
	
	public Cell() {
		setAlive(false);
		setNeighbors(0);
	}
	
	public Cell(Cell c) {
		setAlive(c.alive);
		setNeighbors(c.neighbors);
	}
	
	public Cell(boolean alive, int neighbors) {
		setAlive(alive);
		setNeighbors(neighbors);
	}
	
	/**
	 * @return Se a c�lula est� viva
	 */
	public boolean isAlive() {
		return alive;
	}
	
	/**
	 * Define o status de uma c�lula
	 * @param alive Status da c�lula
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Incrementa em 1 o n�mero de vizinhos da c�lula
	 */
	public void addNeighbor() {
		neighbors++;
	}
	
	/**
	 * Decrementa em 1 o n�mero de vizinhos da c�lula
	 */
	public void removeNeighbor() {
		neighbors--;
	}
	
	/**
	 * @return N�mero de vizinhos da c�lula
	 */
	public int getNeighbors() {
		return neighbors;
	}
	
	/**
	 * Define o n�mero de vizinhos da c�lula
	 * @param neighbors N�mero de vizinhos
	 */
	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}
}
