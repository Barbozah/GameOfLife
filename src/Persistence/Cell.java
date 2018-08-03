package Persistence;

import java.io.Serializable;

/**
 * Classe representativa de cada célula do automato.
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
	 * @return Se a célula está viva
	 */
	public boolean isAlive() {
		return alive;
	}
	
	/**
	 * Define o status de uma célula
	 * @param alive Status da célula
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Incrementa em 1 o número de vizinhos da célula
	 */
	public void addNeighbor() {
		neighbors++;
	}
	
	/**
	 * Decrementa em 1 o número de vizinhos da célula
	 */
	public void removeNeighbor() {
		neighbors--;
	}
	
	/**
	 * @return Número de vizinhos da célula
	 */
	public int getNeighbors() {
		return neighbors;
	}
	
	/**
	 * Define o número de vizinhos da célula
	 * @param neighbors Número de vizinhos
	 */
	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}
}
