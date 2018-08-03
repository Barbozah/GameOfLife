package Persistence;

public class PermissionDeniedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public PermissionDeniedException(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Permiss�o de acesso negada para " + name;
	}
	
	public String getName() {
		return name;
	}
}
