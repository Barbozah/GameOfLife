package Persistence;

import java.io.Serializable;
import java.util.ArrayList;

import Business.PlayerControl;

public class UserData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private PlayerControl player;
	private ArrayList<CellRepositoryControl> data;
	private int selectedIndex;
	
	public UserData(PlayerControl player) {
		this.setPlayer(player);
		data = new ArrayList<>();
	}
	
	public UserData(PlayerControl player, ArrayList<CellRepositoryControl> data) {
		this.setPlayer(player);
		this.data = data;
	}
	
	/**
	 * Define a que usu�rio pertence o dado
	 * @param player
	 */
	public void setPlayer(PlayerControl player) {
		this.player = player;
	}
	
	/**
	 * @return Nome do usu�rio
	 */
	public String getName() {
		return player.getName();
	}
	
	/**
	 * Checa a senha do usu�rio do dado
	 * @param passwordCheck Senha a ser checada
	 * @return Se a senha est� correta
	 */
	public boolean checkPassword(String passwordCheck) {
		if(passwordCheck.equals(this.player.getPassword())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adicina um dado ao usu�rio
	 * @param cellControl Dado a ser adicionado
	 */
	public void addData(CellRepositoryControl cellControl) {
		data.add(cellControl);
	}

	/**
	 * @return Lista de dados do usu�rio
	 */
	public ArrayList<CellRepositoryControl> getData() {
		return data;
	}

	/**
	 * @return �ndice do dado selecionado
	 */
	public int getSelectedIndex() {
		return selectedIndex;
	}

	/**
	 * Seleciona um dado
	 * @param selectedIndex �ndice do dado
	 */
	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
	
}
