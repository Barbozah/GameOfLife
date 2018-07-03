package Business.StaticGridSize;

import Business.CellControl;

/**
 * Interface que extende os m�todos de manipula��o de c�lulas de forma est�tica
 * @author Antonio
 *
 */
public interface StaticCellControl extends CellControl{
	/**
	 * Retorna o n�meros de linhas da matriz de c�lulas
	 * @return (int com o n�mero de linhas)
	 */
	public int getRows();
	
	/**
	 * Retorna o n�meros de colunas da matriz de c�lulas
	 * @return (int com o n�mero de colunas)
	 */
	public int getColumns();
}
