package Persistence;

import java.io.Serializable;

/**
 * Interface que re�ne os m�todos para manipula��o de c�lulas
 * @author Antonio
 */
public interface CellRepositoryControl extends Serializable{
	
	/**
	 * Incrementa em 1 o n�mero de vizinhos de uma c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula) 
	 * @throws CellNotInstantiatedException 
	 */
	public void addNeighbor(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Decrementa em 1 o n�mero de vizinhos de uma c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula) 
	 */
	public void removeNeighbor(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o n�mero de vizinhos de uma c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @param neighbors (n�mero de vizinhos a ser definido)
	 */
	public void setNeighbors(int x, int y, int neighbors) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o n�mero de vizinhos de uma c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @return (inteiro correspondente ao n�mero de vizinhos)
	 */
	public int getNeighbors(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Instancia uma nova c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void addCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Instancia uma nova c�lula definindo o status e o n�mero de vizinhos
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @param alive (status da c�lula)
	 * @param neighbors (n�mero de vizinhos da c�lula)
	 * @throws CellNotInstantiatedException 
	 */
	public void addCell(int x, int y, boolean alive, int neighbors) throws CellNotInstantiatedException;
	
	/**
	 * Destroy uma c�lula instanciada
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula) 
	 */
	public void removeCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma c�lula como morta (false)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void killCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma c�lula como viva (true)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void liveCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma c�lula o par�metro recebido
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @param alive (status a ser definido)
	 */
	public void setAlive(int x, int y, boolean alive) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o status de uma c�lula (viva/morta)(true/false)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @return (status da c�lula)
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
