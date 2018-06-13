package Business;

import Persistence.Backup;

/**
 * Classe onde ocorre o ambiente da simula��o do automato celular.
 * @author Antonio
 */
public class Simulation implements Runnable {
	
	public static final long MAX_VELOCITY = 5000;
	
	private Stopwatch runtime;
	private boolean paused = false;
	private long velocity;
	private int generation;
	private int idle;
	private int rows;
	private int columns;
	private int count;
	private Cell[][] cellgrid;
	private Cell[][] buffer;
	private Backup archive;
	
	public class Upgrade implements Runnable {
		
		private int x, y;
		
		public Upgrade(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void run() {
			
			for(int i=y-1;i<=y+1;i++) {
				for(int j=x-1;j<=x+1;j++) {
					if(i==y && j==x || i < 0 || i >= rows-1 || j < 0 || j >= columns-1) {
						continue;
					}
					if(cellgrid[i][j].isAlive()) {
						cellgrid[y][x].addNeighbor();
					}
				}
			}
			
			int neighbors = cellgrid[y][x].getNeighbors();
			boolean isAlive = cellgrid[y][x].isAlive();
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
			
			buffer[y][x] = new Cell(alive, 0);
			count++;
		}
		
	}
	
	/**
	 * Construtor respons�vel por iniciar as vari�veis com valor default
	 */
	public Simulation(int rows, int columns) {
		setRuntime(new Stopwatch());
		setVelocity(4000);
		setGeneration(0);
		setIdle(100);
		setRows(rows);
		setColumns(columns);
		setCellgrid(rows, columns);
	}
	
	/**
	 * M�todo respons�vel por alterar uma determinada c�lula contida na grade de c�lulas
	 * 
	 * @param p player respons�vel por fornecer o comportamento do m�todo
	 * @param x coordenada, do eixo das abcissas, da c�lula que deve ser alterada  
	 * @param y coordenada, do eixo das ordenadas, da c�lula que deve ser alterada
	 */
	public void mutation(Player p, int x, int y) {
		cellgrid[y][x].setAlive(p.getCursorBehavior());
	}
	
	/**
	 * M�todo respons�vel por atualizar a gera��o
	 * Ainda em desenvolvimento
	 */
	public void evolution() {
		buffer = new Cell[rows][columns];
		count = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				//new Thread(new Upgrade(j, i)).start();
				new Upgrade(j, i).run();
			}
		}
		while(count < rows*columns-1) {}
		setCellgrid(buffer);
		
	}
	
	/**
	 * M�todo criado para fiz de teste da l�gica de gera��es
	 */
	public void showGrid() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				
				if(cellgrid[i][j].isAlive()) {
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
	@Override
	public void run() {
		while(!paused) {
			showGrid();
			evolution();
			generation++;
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
		run();
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

	public Stopwatch getRuntime() {
		return runtime;
	}

	public void setRuntime(Stopwatch runtime) {
		this.runtime = runtime;
	}

	public long getVelocity() {
		return velocity;
	}

	public void setVelocity(long velocity) {
		this.velocity = velocity;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getIdle() {
		return idle;
	}

	public void setIdle(int idle) {
		this.idle = idle;
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Cell[][] getCellgrid() {
		return cellgrid;
	}

	public void setCellgrid(Cell[][] cellgrid) {
		this.cellgrid = cellgrid;
	}
	
	public void setCellgrid(int rows, int colums) {
		this.cellgrid = new Cell[rows][colums];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<colums;j++) {
				cellgrid[i][j] = new Cell();
			}
		}
	}

	public Backup getArchive() {
		return archive;
	}

	public void setArchive(Backup archive) {
		this.archive = archive;
	}
	
}
