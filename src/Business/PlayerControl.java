package Business;

import java.io.Serializable;

public interface PlayerControl extends Serializable{
	
	/**
	 * @return Nome do usuário 
	 */
	public String getName();
	
	/**
	 * @param name Define o nome do usuário
	 */
	public void setName(String name);
	
	/**
	 * @return Senha do usuário
	 */
	public String getPassword();
	
}
