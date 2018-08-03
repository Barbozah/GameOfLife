package Persistence;

import java.io.IOException;

import Business.PlayerControl;

public interface RepositoryControl {
	
	public void save(String url, UserData data) throws IOException;
	
	public void restore(String url, PlayerControl player) throws IOException, ClassNotFoundException, PermissionDeniedException, PlayerNotFoundException;
	
	/**
	 * Procura os dados de um usuário
	 * @param player Quem deve ser procurado
	 * @return Dados do usuário
	 * @throws PlayerNotFoundException Caso o usuário não for encontrado 
	 */
	public UserData search(PlayerControl player) throws PlayerNotFoundException;
	
	/**
	 * @param oldPlayer Usuário a ser atualizado
	 * @param updatedPlayer Informações nomas do usuário
	 * @throws PlayerNotFoundException Caso o usuário não for encontrado
	 */
	public void update(PlayerControl oldPlayer, PlayerControl updatedPlayer) throws PlayerNotFoundException;
	
	/**
	 * @param player Cadastra um novo usuário no repositório
	 */
	public void register(PlayerControl player);
	
	/**
	 * Adiciona um dado ao usuário no repósitorio
	 * @param player Usuário a ser procurado
	 * @param cellControl Dado a adicionar
	 * @throws PlayerNotFoundException Usuário a ser procurado
	 */
	public void addData(PlayerControl player, CellRepositoryControl cellControl) throws PlayerNotFoundException;
	
	/**
	 * Remove um usuário do repositório
	 * @param player Usuário a ser removido
	 * @throws PlayerNotFoundException Usuário a ser procurado
	 */
	public void delete(PlayerControl player) throws PlayerNotFoundException;
	
}
