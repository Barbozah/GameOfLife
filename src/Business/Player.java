package Business;

/**
 * Classe respons�vel por abstrair os conceitos do usu�rio.
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
