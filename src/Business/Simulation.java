package Business;

public interface Simulation {
	
	public static final long MAX_VELOCITY = 1000;
	
	public void mutation(boolean behavior, int x, int y);
	public void update(int x, int y);
	public void evolution();
	public long getVelocity();
	public void setVelocity(long velocity);
	public int getGeneration();
	public void setGeneration(int generation);
	public int getIdle();
	public void setIdle(int idle);
	public CellControl getCellControl();
	public void setCellControl(CellControl cellControl);
	public Stopwatch getRuntime();
	public void setRuntime(Stopwatch runtime);
}
