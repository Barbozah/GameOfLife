package Persistence;

import java.io.IOException;

import Business.PlayerControl;

public interface RepositoryControl {
	
	public void save(String url, UserData data) throws IOException;
	
	public void restore(String url, PlayerControl player) throws IOException, ClassNotFoundException, PermissionDeniedException, PlayerNotFoundException;
	
	/**
	 * Procura os dados de um usu�rio
	 * @param player Quem deve ser procurado
	 * @return Dados do usu�rio
	 * @throws PlayerNotFoundException Caso o usu�rio n�o for encontrado 
	 */
	public UserData search(PlayerControl player) throws PlayerNotFoundException;
	
	/**
	 * @param oldPlayer Usu�rio a ser atualizado
	 * @param updatedPlayer Informa��es nomas do usu�rio
	 * @throws PlayerNotFoundException Caso o usu�rio n�o for encontrado
	 */
	public void update(PlayerControl oldPlayer, PlayerControl updatedPlayer) throws PlayerNotFoundException;
	
	/**
	 * @param player Cadastra um novo usu�rio no reposit�rio
	 */
	public void register(PlayerControl player);
	
	/**
	 * Adiciona um dado ao usu�rio no rep�sitorio
	 * @param player Usu�rio a ser procurado
	 * @param cellControl Dado a adicionar
	 * @throws PlayerNotFoundException Usu�rio a ser procurado
	 */
	public void addData(PlayerControl player, CellRepositoryControl cellControl) throws PlayerNotFoundException;
	
	/**
	 * Remove um usu�rio do reposit�rio
	 * @param player Usu�rio a ser removido
	 * @throws PlayerNotFoundException Usu�rio a ser procurado
	 */
	public void delete(PlayerControl player) throws PlayerNotFoundException;
	
}
