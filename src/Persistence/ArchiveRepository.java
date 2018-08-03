package Persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Business.PlayerControl;

public class ArchiveRepository implements RepositoryControl {

	private ArrayList<UserData> array;
	
	public ArchiveRepository() {
		array = new ArrayList<>();
	}
	
	@Override
	public void save(String url, UserData data) throws IOException {
		Path path = Paths.get(url);
		if(!Files.isDirectory(path.getParent())) {
			Files.createDirectory(path.getParent());
		}
		if(!Files.exists(path)) {
			Files.createFile(path);
		}
		ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
		oos.writeObject(data);
		oos.close();
	}
	
	@Override
	public void restore(String url, PlayerControl player) throws IOException, ClassNotFoundException, PermissionDeniedException, PlayerNotFoundException {
		Path path = Paths.get(url);
		if(!Files.exists(path)) {
			throw new IOException();
		}
		ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
		UserData data = (UserData) ois.readObject();
		if(!data.checkPassword(player.getPassword()) || !data.getName().equals(player.getName())) {
			throw new PermissionDeniedException(player.getName());
		}
		array.add(data);
		ArrayList<CellRepositoryControl> temp = new ArrayList<>();
		for (CellRepositoryControl cellControl : data.getData()) {
			temp.add(cellControl);
		}
		for (CellRepositoryControl c : temp) {
			addData(player, c);
			temp = search(player).getData();
			search(player).addData(c);
		}
		ois.close();
	}

	@Override
	public UserData search(PlayerControl player) throws PlayerNotFoundException {
		for (UserData userData : array) {
			if(userData.getName().equals(player.getName()) && userData.checkPassword(player.getPassword())) {
				return userData;
			}
		}
		throw new PlayerNotFoundException(player);
	}

	@Override
	public void update(PlayerControl oldPlayer, PlayerControl updatedPlayer) throws PlayerNotFoundException {
		search(oldPlayer).setPlayer(updatedPlayer);
	}

	@Override
	public void register(PlayerControl player) {
		array.add(new UserData(player));
	}

	@Override
	public void addData(PlayerControl player, CellRepositoryControl cellControl) throws PlayerNotFoundException {
		search(player).addData(cellControl);
	}

	@Override
	public void delete(PlayerControl player) throws PlayerNotFoundException {
		array.remove(search(player));
	}

}
