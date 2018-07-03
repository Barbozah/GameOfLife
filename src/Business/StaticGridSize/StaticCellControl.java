package Business.StaticGridSize;

import Business.CellControl;

/**
 * Interface que extende os métodos de manipulação de células de forma estática
 * @author Antonio
 *
 */
public interface StaticCellControl extends CellControl{
	/**
	 * Retorna o números de linhas da matriz de células
	 * @return (int com o número de linhas)
	 */
	public int getRows();
	
	/**
	 * Retorna o números de colunas da matriz de células
	 * @return (int com o número de colunas)
	 */
	public int getColumns();
}
