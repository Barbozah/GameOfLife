package Business.DynamicGridSize;

import Business.CellControl;
import Business.CellNotInstantiatedException;

/**
 * Interface que extende os métodos de manipulação de células de forma dinâmica
 * @author Antonio
 *
 */
public interface DynamicCellControl extends CellControl {
	
	/**
	 * Procura uma célula por coordenada estática, caso não ache ela será instanciada
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public CellVirtual getCell(int x, int y);
	
	/**
	 * Procura uma célula por coordenada dinâmica, caso não ache ela será instanciada
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public CellVirtual getCell(int staticIndex) throws CellNotInstantiatedException;
	
	/**
	 * Retorna o número de células instanciadas
	 * @return (int com o número de instâncias)
	 */
	public int length();
}
