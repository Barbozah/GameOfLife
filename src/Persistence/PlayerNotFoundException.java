package Persistence;

import Business.PlayerControl;

public class PlayerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private PlayerControl player;
	
	public PlayerNotFoundException(PlayerControl player) {
		this.player = player;
	}

	public PlayerControl getPlayer() {
		return player;
	}
	
}
