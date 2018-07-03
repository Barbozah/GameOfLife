package Business.DynamicGridSize;

import Business.CellControl;
import Business.CellNotInstantiatedException;

/**
 * Interface que extende os m�todos de manipula��o de c�lulas de forma din�mica
 * @author Antonio
 *
 */
public interface DynamicCellControl extends CellControl {
	
	/**
	 * Procura uma c�lula por coordenada est�tica, caso n�o ache ela ser� instanciada
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public CellVirtual getCell(int x, int y);
	
	/**
	 * Procura uma c�lula por coordenada din�mica, caso n�o ache ela ser� instanciada
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public CellVirtual getCell(int staticIndex) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o n�mero de c�lulas instanciadas
	 * @return (int com o n�mero de inst�ncias)
	 */
	public int length();
}
