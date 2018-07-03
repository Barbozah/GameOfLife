package Business.DynamicGridSize;

import Business.Cell;

/**
 * Classe que herda as caracteristicas de célula 
 * com adicional de atributos para uma coordenada virtual
 * @author Antonio
 *
 */
public class CellVirtual extends Cell{
	private int x;
	private int y;
	
	public CellVirtual() {
		super();
	}
	
	public CellVirtual(boolean alive, int neighbors) {
		super(alive, neighbors);
	}
	
	public CellVirtual(int x, int y) {
		super();
		setX(x);
		setY(y);
	}
	
	public CellVirtual(int x, int y, boolean alive, int neighbors) {
		super(alive, neighbors);
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
