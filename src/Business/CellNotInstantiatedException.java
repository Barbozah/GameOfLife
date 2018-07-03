package Business;

/**
 * Exce��o definida para lan�ar erros de acesso a c�lulas n�o instanciadas
 * @author Antonio
 *
 */
public class CellNotInstantiatedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int x, y, staticIndex;
	
	/**
	 * Construtor para controle de c�lulas por coordenadas din�micas
	 * @param x (coordenada x da c�lula)
	 * @param y (coordenada y da c�lula)
	 */
	public CellNotInstantiatedException(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * Contrutor para controle de c�lulas por coordenadas est�ticas
	 * @param staticIndex (�ndice est�tico de uma c�lula)
	 */
	public CellNotInstantiatedException(int staticIndex) {
		setStaticIndex(staticIndex);
	}

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

	public int getStaticIndex() {
		return staticIndex;
	}

	public void setStaticIndex(int staticIndex) {
		this.staticIndex = staticIndex;
	}

}
