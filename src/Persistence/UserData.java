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
	 * Define a que usuário pertence o dado
	 * @param player
	 */
	public void setPlayer(PlayerControl player) {
		this.player = player;
	}
	
	/**
	 * @return Nome do usuário
	 */
	public String getName() {
		return player.getName();
	}
	
	/**
	 * Checa a senha do usuário do dado
	 * @param passwordCheck Senha a ser checada
	 * @return Se a senha está correta
	 */
	public boolean checkPassword(String passwordCheck) {
		if(passwordCheck.equals(this.player.getPassword())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adicina um dado ao usuário
	 * @param cellControl Dado a ser adicionado
	 */
	public void addData(CellRepositoryControl cellControl) {
		data.add(cellControl);
	}

	/**
	 * @return Lista de dados do usuário
	 */
	public ArrayList<CellRepositoryControl> getData() {
		return data;
	}

	/**
	 * @return Índice do dado selecionado
	 */
	public int getSelectedIndex() {
		return selectedIndex;
	}

	/**
	 * Seleciona um dado
	 * @param selectedIndex Índice do dado
	 */
	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
	
}
