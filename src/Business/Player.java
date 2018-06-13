package Business;

/**
 * Classe responsável por abstrair os conceitos do usuário.
 * @author Antonio
 */
public class Player {
	static final boolean CURSOR_KILL = false;
	static final boolean CURSOR_LIVE = true;
	
	private boolean cursorBehavior;
	private int score;
	
	public Player() {
		setCursorBehavior(CURSOR_LIVE);
		setScore(0);
	}
	
	public Player(boolean cursorBehavior, int score) {
		setCursorBehavior(cursorBehavior);
		setScore(score);
	}
	
	public boolean getCursorBehavior() {
		return cursorBehavior;
	}
	public void setCursorBehavior(boolean cursorBehavior) {
		this.cursorBehavior = cursorBehavior;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
