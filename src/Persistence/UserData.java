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
	
	public void setPlayer(PlayerControl player) {
		this.player = player;
	}
	
	public String getName() {
		return player.getName();
	}
	
	public boolean checkPassword(String passwordCheck) {
		if(passwordCheck.equals(this.player.getPassword())) {
			return true;
		}
		return false;
	}
	
	public void addData(CellRepositoryControl cellControl) {
		data.add(cellControl);
	}

	public ArrayList<CellRepositoryControl> getData() {
		return data;
	}

	public int getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = selectedIndex;
	}
	
}
