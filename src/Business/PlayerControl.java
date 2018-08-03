package Business;

import java.io.Serializable;

public interface PlayerControl extends Serializable{
	
	/**
	 * @return Nome do usu�rio 
	 */
	public String getName();
	
	/**
	 * @param name Define o nome do usu�rio
	 */
	public void setName(String name);
	
	/**
	 * @return Senha do usu�rio
	 */
	public String getPassword();
	
}
