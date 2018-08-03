package Business;

/**
 * Classe responsável por abstrair os conceitos do usuário.
 * @author Antonio
 */
public class Player implements PlayerControl {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	
	public Player(String name, String password) {
		setName(name);
		this.password = password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPassword() {
		return password;
	}
}
