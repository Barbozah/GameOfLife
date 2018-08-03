package Persistence;

import java.io.IOException;

import Business.PlayerControl;

public interface RepositoryControl {
	
	public void save(String url, UserData data) throws IOException;
	
	public void restore(String url, PlayerControl player) throws IOException, ClassNotFoundException, PermissionDeniedException, PlayerNotFoundException;
	
	/**
	 * 
	 * @param player
	 * @return
	 * @throws PlayerNotFoundException 
	 */
	public UserData search(PlayerControl player) throws PlayerNotFoundException;
	
	/**
	 * 
	 * @param oldPlayer
	 * @param updatedPlayer
	 * @throws PlayerNotFoundException
	 */
	public void update(PlayerControl oldPlayer, PlayerControl updatedPlayer) throws PlayerNotFoundException;
	
	/**
	 * 
	 * @param player
	 */
	public void register(PlayerControl player);
	
	/**
	 * 
	 * @param player
	 * @param cellControl
	 * @throws PlayerNotFoundException
	 */
	public void addData(PlayerControl player, CellRepositoryControl cellControl) throws PlayerNotFoundException;
	
	/**
	 * 
	 * @param player
	 * @throws PlayerNotFoundException
	 */
	public void delete(PlayerControl player) throws PlayerNotFoundException;
	
}
