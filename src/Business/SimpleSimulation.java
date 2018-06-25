package Business;

/**
 * Classe onde ocorre o ambiente da simula��o do automato celular.
 * @author Antonio
 */
public class SimpleSimulation implements Simulation {
	
	private Stopwatch runtime;
	private boolean paused = false;
	private long velocity;
	private int generation;
	private int idle;
	private CellControl cellControl;
	private CellControl bufferControl;
	
	/**
	 * Construtor respons�vel por iniciar as vari�veis com valor default
	 */
	public SimpleSimulation(int rows, int columns) {
		setRuntime(new Stopwatch());
		setVelocity(4000);
		setGeneration(0);
		setIdle(100);
		setCellControl(new Cellgrid(rows, columns));
	}
	
	/**
	 * M�todo respons�vel por alterar uma determinada c�lula contida na grade de c�lulas
	 * 
	 * @param p player respons�vel por fornecer o comportamento do m�todo
	 * @param x coordenada, do eixo das abcissas, da c�lula que deve ser alterada  
	 * @param y coordenada, do eixo das ordenadas, da c�lula que deve ser alterada
	 */
	@Override
	public void mutation(boolean behavior, int x, int y) {
		cellControl.setAlive(x, y, behavior);
	}
	
	/**
	 * M�todo respons�vel por atualizar um �ndice dentro da matriz em quest�o
	 * 
	 * @param x coordenada, do eixo das abcissas, da c�lula que deve ser atualizada
	 * @param y coordenada, do eixo das ordenadas, da c�lula que deve ser atualizada
	 */
	@Override
	public void update(int x, int y) {
		
		for(int i=y-1;i<=y+1;i++) {
			for(int j=x-1;j<=x+1;j++) {
				if(i==y && j==x || i < 0 || i >= cellControl.getRows()-1 || j < 0 || j >= cellControl.getColumns()-1) {
					continue;
				}
				if(cellControl.isAlive(j, i)) {
					cellControl.addNeighbor(x, y);
				}
			}
		}
		int neighbors = cellControl.getNeighbors(x, y);
		boolean isAlive = cellControl.isAlive(x, y);
		boolean alive = false;
		
		if(neighbors > 3 || neighbors < 2) {
			alive = false;
		}
		
		if(isAlive == false && neighbors == 3) {
			alive = true;
		}
		
		if(isAlive && ((neighbors == 2 )||(neighbors == 3))) {
			alive = isAlive;
		}
		
		bufferControl.addCell(x, y, alive, 0);
	}
	
	/**
	 * M�todo respons�vel por atualizar a gera��o
	 * Ainda em desenvolvimento
	 */
	@Override
	public void evolution() {
		bufferControl = new Cellgrid(cellControl.getRows(), cellControl.getColumns());
		for(int i=0;i<cellControl.getRows();i++) {
			for(int j=0;j<cellControl.getColumns();j++) {
				update(j, i);
			}
		}
		generation++;
		setCellControl(bufferControl);
	}
	
	/**
	 * M�todo criado para fiz de teste da l�gica de gera��es
	 */
	public void showGrid() {
		for(int i=0;i<cellControl.getRows();i++) {
			for(int j=0;j<cellControl.getColumns();j++) {
				
				if(cellControl.isAlive(j, i)) {
					System.out.print(1);
				}else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
		System.out.println("Gera��o: " + generation 
						+ "\nTempo Decorrido: " + runtime.getTime());
	}
	
	/**
	 * M�todo @Override respons�vel pelo fluxo de execu��o
	 */
	public void run() {
		while(!paused) {
			showGrid();
			evolution();
			try {
				Thread.sleep(MAX_VELOCITY - velocity);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
	
	/**
	 * M�todo que deve ser chamado para iniciar a simula��o. 
	 */
	public void play() {
		runtime.play();
		//run();
	}
	
	/**
	 * M�todo respons�vel por pausar a simula��o.
	 */
	public void pause() {
		runtime.pause();
	}
	
	/**
	 * M�todo que deve ser chamado no fim da simula��o.
	 */
	public void stop() {
		runtime.stop();
	}
	
	@Override
	public Stopwatch getRuntime() {
		return runtime;
	}
	
	@Override
	public void setRuntime(Stopwatch runtime) {
		this.runtime = runtime;
	}

	@Override
	public long getVelocity() {
		return velocity;
	}

	@Override
	public void setVelocity(long velocity) {
		this.velocity = Simulation.MAX_VELOCITY - velocity;
	}

	@Override
	public int getGeneration() {
		return generation;
	}

	@Override
	public void setGeneration(int generation) {
		this.generation = generation;
	}

	@Override
	public int getIdle() {
		return idle;
	}

	@Override
	public void setIdle(int idle) {
		this.idle = idle;
	}
	
	@Override
	public CellControl getCellControl() {
		return cellControl;
	}

	@Override
	public void setCellControl(CellControl cellControl) {
		this.cellControl = cellControl;
	}
}
