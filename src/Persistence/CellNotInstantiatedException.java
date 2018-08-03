package Persistence;

/**
 * Exceção definida para lançar erros de acesso a células não instanciadas
 * @author Antonio
 *
 */
public class CellNotInstantiatedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int x, y;
	
	/**
	 * Construtor para controle de células por coordenadas dinâmicas
	 * @param x (coordenada x da célula)
	 * @param y (coordenada y da célula)
	 */
	public CellNotInstantiatedException(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Contrutor para controle de células por coordenadas estáticas
	 * @param staticIndex (índice estático de uma célula)
	 */

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + " Coord = {x = " + x + ", y = " + y + "}";
	}

}
