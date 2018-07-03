package Business;

/**
 * Interface que reúne os métodos para manipulação de células
 * @author Antonio
 */
public interface CellControl {
	
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
	 * @throws CellNotInstantiatedException 
	 */
	public void removeNeighbor(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o número de vizinhos de uma célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @param neighbors (número de vizinhos a ser definido)
	 * @throws CellNotInstantiatedException 
	 */
	public void setNeighbors(int x, int y, int neighbors) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o número de vizinhos de uma célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @return (inteiro correspondente ao número de vizinhos)
	 * @throws CellNotInstantiatedException 
	 */
	public int getNeighbors(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Instancia uma nova célula
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public void addCell(int x, int y);
	
	/**
	 * Instancia uma nova célula definindo o status e o número de vizinhos
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @param alive (status da célula)
	 * @param neighbors (número de vizinhos da célula)
	 */
	public void addCell(int x, int y, boolean alive, int neighbors);
	
	/**
	 * Destroy uma célula instanciada
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @throws CellNotInstantiatedException 
	 */
	public void removeCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma célula como morta (false)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @throws CellNotInstantiatedException 
	 */
	public void killCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma célula como viva (true)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @throws CellNotInstantiatedException
	 */
	public void liveCell(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Define o status de uma célula o parâmetro recebido
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @param alive (status a ser definido)
	 * @throws CellNotInstantiatedException
	 */
	public void setAlive(int x, int y, boolean alive) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o status de uma célula (viva/morta)(true/false)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @return (status da célula)
	 * @throws CellNotInstantiatedException
	 */
	public boolean isAlive(int x, int y) throws CellNotInstantiatedException;
}
