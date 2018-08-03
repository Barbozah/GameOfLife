package Business;

import Persistence.CellRepositoryControl;
import Persistence.CellNotInstantiatedException;

/**
 * Interface que re�ne os m�todos para manipula��o de uma simula��o
 * @author Antonio
 *
 */
public interface SimulationControl {
	
	/**
	 * Constante para velocidade m�xima de atualiza��o de gera��es 
	 * ou taxa de atualiza��o
	 */
	public static final long MAX_VELOCITY = 1000;
	
	/**
	 * Gera uma muta��o em uma c�lula
	 * @param behavior ( (viver/matar) uma c�lula)
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void mutation(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Atualiza uma c�lula em um buffer para a pr�xima gera��o
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public void update(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Utiliza o updade() para atualizar todas as c�lulas para a pr�xima gera��o
	 */
	public void selection() throws CellNotInstantiatedException;
	
	/**
	 * Retorna o valor da taxa de atualiza��o
	 * @return (long que representa a taxa)
	 */
	public long getVelocity();
	
	/**
	 * Define o valor da taxa de atualiza��o
	 * @param velocity (long com o valor da taxa)
	 */
	public void setVelocity(long velocity);
	
	/**
	 * Retorna o n�mero de gera��es at� ent�o decorridas
	 * @return (int com o n�mero de gera��es)
	 */
	public int getGeneration();
	
	/**
	 * Retorna a inst�ncia do r�logio de simula��o
	 * @return (inst�ncia da classe Stopwatch)
	 */
	public Stopwatch getRuntime();
	
	/**
	 * 
	 * @return
	 */
	public CellRepositoryControl getCellControl();
	
	/**
	 * 
	 * @param cellControl
	 */
	public void setCellControl(CellRepositoryControl cellControl);
	
	/**
	 * 
	 * @return
	 */
	public boolean isPaused();
	
	/**
	 * 
	 */
	public void pause();
	
	/**
	 * 
	 */
	public void play();
	
	/**
	 * 
	 */
	public boolean getCursorBehavior();
	
	/**
	 * 
	 * @param behavior
	 */
	public void setCursorBehavior(boolean behavior);
}
