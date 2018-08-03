package Persistence;

import Business.PlayerControl;

public class PersistenceFacade {
	private RepositoryControl repository;
	private static PersistenceFacade instance;
	
	private PersistenceFacade() {
		this.repository = new ArchiveRepository();
	}
	
	public static PersistenceFacade getInstance() {
		if(PersistenceFacade.instance == null) {
			PersistenceFacade.instance = new PersistenceFacade();
		}
		return PersistenceFacade.instance;
	}

	public RepositoryControl getRepository() {
		return repository;
	}
	
	public void register(PlayerControl player) {
		repository.register(player);
	}
	
	public void delete(PlayerControl player) throws PlayerNotFoundException {
		repository.delete(player);
	}
	
	public void update(PlayerControl oldPlayer, PlayerControl updatedPlayer) throws PlayerNotFoundException {
		repository.update(oldPlayer, updatedPlayer);
	}
	
	public UserData search(PlayerControl player) throws PlayerNotFoundException {
		return repository.search(player);
	}
}
