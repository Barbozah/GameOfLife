package Persistence;

import java.io.Serializable;

/**
 * Interface que reúne os métodos para manipulação de células
 * @author Antonio
 */
public interface CellRepositoryControl extends Serializable{
	
	/**
	 * Incrementa em 1 o número de vizinhos de uma célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula) 
	 * @throws CellNotInstantiatedException 
	 */
	public void addNeighbor(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Decrementa em 1 o número de vizinhos de uma célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula) 
	 */
	public void removeNeighbor(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o número de vizinhos de uma célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @param neighbors (número de vizinhos a ser definido)
	 */
	public void setNeighbors(int x, int y, int neighbors) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o número de vizinhos de uma célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @return (inteiro correspondente ao número de vizinhos)
	 */
	public int getNeighbors(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Instancia uma nova célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public void addCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Instancia uma nova célula definindo o status e o número de vizinhos
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @param alive (status da célula)
	 * @param neighbors (número de vizinhos da célula)
	 * @throws CellNotInstantiatedException 
	 */
	public void addCell(int x, int y, boolean alive, int neighbors) throws CellNotInstantiatedException;
	
	/**
	 * Destroy uma célula instanciada
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula) 
	 */
	public void removeCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma célula como morta (false)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public void killCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma célula como viva (true)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public void liveCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma célula o parâmetro recebido
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @param alive (status a ser definido)
	 */
	public void setAlive(int x, int y, boolean alive) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o status de uma célula (viva/morta)(true/false)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @return (status da célula)
	 */
	public boolean isAlive(int x, int y) throws CellNotInstantiatedException;
	
	public String createdIn();
	
	/**
	 * 
	 * @param rows
	 * @param columns
	 */
	public void setDimention(int rows, int columns);
	
	/**
	 * 
	 * @param scale
	 */
	public void setIdealDimention(int scale);
	
	/**
	 * 
	 * @return
	 */
	public int getRows();

	/**
	 * 
	 * @return
	 */
	public int getColumns();
	
	/**
	 * 
	 * @return
	 */
	public CellRepositoryControl specialInstance();
	
	/**
	 * 
	 */
	public void resetIterator();
	
	/**
	 * 
	 * @return
	 */
	public boolean hasNext();
	
	/**
	 * 
	 * @return
	 */
	public Coordinate next();
}
