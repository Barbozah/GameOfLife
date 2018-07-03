package Business.StaticGridSize;

import Business.CellNotInstantiatedException;
import Business.SimulationControl;
import Business.Stopwatch;

/**
 * Classe onde ocorre o ambiente da simulação do automato celular.
 * @author Antonio
 */
public class StaticSimulation implements StaticSimulationControl {
	
	private Stopwatch runtime;
	private boolean paused = false;
	private long velocity;
	private int generation;
	private StaticCellControl cellControl;
	private StaticCellControl bufferControl;
	
	/**
	 * Construtor responsável por iniciar as variáveis com valor default
	 */
	public StaticSimulation(int rows, int columns) {
		runtime = new Stopwatch();
		setVelocity(SimulationControl.MAX_VELOCITY);
		generation = 0;
		setCellControl(new CellStaticGrid(rows, columns));
	}
	
	/**
	 * Método responsável por alterar uma determinada célula contida na grade de células
	 * 
	 * @param p player responsável por fornecer o comportamento do método
	 * @param x coordenada, do eixo das abcissas, da célula que deve ser alterada  
	 * @param y coordenada, do eixo das ordenadas, da célula que deve ser alterada
	 */
	@Override
	public void mutation(boolean behavior, int x, int y) throws CellNotInstantiatedException{
		cellControl.setAlive(x, y, behavior);
	}
	
	/**
	 * Método responsável por atualizar um índice dentro da matriz em questão
	 * 
	 * @param x coordenada, do eixo das abcissas, da célula que deve ser atualizada
	 * @param y coordenada, do eixo das ordenadas, da célula que deve ser atualizada
	 */
	@Override
	public void update(int x, int y) throws CellNotInstantiatedException{
		
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
	 * Método responsável por atualizar a geração
	 * Ainda em desenvolvimento
	 */
	@Override
	public void selection() throws CellNotInstantiatedException{
		bufferControl = new CellStaticGrid(cellControl.getRows(), cellControl.getColumns());
		for(int i=0;i<cellControl.getRows();i++) {
			for(int j=0;j<cellControl.getColumns();j++) {
				update(j, i);
			}
		}
		generation++;
		setCellControl(bufferControl);
	}
	
	/**
	 * Método criado para fiz de teste da lógica de gerações
	 */
	public void showGrid() throws CellNotInstantiatedException{
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
		System.out.println("Geração: " + generation 
						+ "\nTempo Decorrido: " + runtime.getTime());
	}
	
	/**
	 * Método @Override responsável pelo fluxo de execução
	 */
	public void run() throws CellNotInstantiatedException{
		while(!paused) {
			showGrid();
			selection();
			try {
				Thread.sleep(MAX_VELOCITY - velocity);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
	
	/**
	 * Método que deve ser chamado para iniciar a simulação. 
	 */
	public void play() {
		runtime.play();
		//run();
	}
	
	/**
	 * Método responsável por pausar a simulação.
	 */
	public void pause() {
		runtime.pause();
	}
	
	/**
	 * Método que deve ser chamado no fim da simulação.
	 */
	public void stop() {
		runtime.stop();
	}
	
	@Override
	public Stopwatch getRuntime() {
		return runtime;
	}

	@Override
	public long getVelocity() {
		return velocity;
	}

	@Override
	public void setVelocity(long velocity) {
		this.velocity = SimulationControl.MAX_VELOCITY - velocity;
	}

	@Override
	public int getGeneration() {
		return generation;
	}
	
	@Override
	public StaticCellControl getCellControl() {
		return cellControl;
	}

	@Override
	public void setCellControl(StaticCellControl cellControl) {
		this.cellControl = cellControl;
	}
}
