package Business;

/**
 * Interface que reúne os métodos para manipulação de uma simulação
 * @author Antonio
 *
 */
public interface SimulationControl {
	
	/**
	 * Constante para velocidade máxima de atualização de gerações 
	 * ou taxa de atualização
	 */
	public static final long MAX_VELOCITY = 1000;
	
	/**
	 * Gera uma mutação em uma célula
	 * @param behavior ( (viver/matar) uma célula)
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @throws CellNotInstantiatedException
	 */
	public void mutation(boolean behavior, int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Atualiza uma célula em um buffer para a próxima geração
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 * @throws CellNotInstantiatedException
	 */
	public void update(int x, int y) throws CellNotInstantiatedException;
	
	/**
	 * Utiliza o updade() para atualizar todas as células para a próxima geração
	 * @throws CellNotInstantiatedException
	 */
	public void selection() throws CellNotInstantiatedException;
	
	/**
	 * Retorna o valor da taxa de atualização
	 * @return (long que representa a taxa)
	 */
	public long getVelocity();
	
	/**
	 * Define o valor da taxa de atualização
	 * @param velocity
	 */
	public void setVelocity(long velocity);
	
	/**
	 * Retorna o número de gerações até então decorridas
	 * @return (int com o número de gerações)
	 */
	public int getGeneration();
	
	/**
	 * Retorna a instância do rélogio de simulação
	 * @return (instância da classe Stopwatch)
	 */
	public Stopwatch getRuntime();
}
