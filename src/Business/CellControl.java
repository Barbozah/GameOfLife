package Business;

/**
 * Interface que re�ne os m�todos para manipula��o de c�lulas
 * @author Antonio
 */
public interface CellControl {
	
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
	 * @throws CellNotInstantiatedException 
	 */
	public void removeNeighbor(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o n�mero de vizinhos de uma c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @param neighbors (n�mero de vizinhos a ser definido)
	 * @throws CellNotInstantiatedException 
	 */
	public void setNeighbors(int x, int y, int neighbors) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o n�mero de vizinhos de uma c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @return (inteiro correspondente ao n�mero de vizinhos)
	 * @throws CellNotInstantiatedException 
	 */
	public int getNeighbors(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Instancia uma nova c�lula
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void addCell(int x, int y);
	
	/**
	 * Instancia uma nova c�lula definindo o status e o n�mero de vizinhos
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @param alive (status da c�lula)
	 * @param neighbors (n�mero de vizinhos da c�lula)
	 */
	public void addCell(int x, int y, boolean alive, int neighbors);
	
	/**
	 * Destroy uma c�lula instanciada
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @throws CellNotInstantiatedException 
	 */
	public void removeCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma c�lula como morta (false)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @throws CellNotInstantiatedException 
	 */
	public void killCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma c�lula como viva (true)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @throws CellNotInstantiatedException
	 */
	public void liveCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma c�lula o par�metro recebido
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @param alive (status a ser definido)
	 * @throws CellNotInstantiatedException
	 */
	public void setAlive(int x, int y, boolean alive) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o status de uma c�lula (viva/morta)(true/false)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 * @return (status da c�lula)
	 * @throws CellNotInstantiatedException
	 */
	public boolean isAlive(int x, int y) throws CellNotInstantiatedException;
}
