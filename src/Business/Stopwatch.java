package Business;

import java.text.DateFormat;
import java.util.Date;

/**
 * Classe criada para monitorar o tempo de simulação
 * @author Antonio
 */
public class Stopwatch {
	
	private long time;
	private long total;
	private String first;
	private String current;
	private Thread runner;
	private boolean paused;
	
	public Stopwatch() {
		time = 0;
		total = 0;
	}
	
	/**
	 * Inicia o contador da simulação e define um Runnable responsável por capturar o tempo
	 */
	public void start() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while(!Thread.interrupted()) {
					if(first == null) {
						DateFormat df = DateFormat.getTimeInstance();
						first = df.format(new Date());
						total = total + time;
					}
					DateFormat df = DateFormat.getTimeInstance();
					current = df.format(new Date());
					time = hourToMillisecond(current) - hourToMillisecond(first);
				}
			}
		};
		runner = new Thread(r);
		runner.start();
	}
	
	/**
	 * Método usado para converter uma String formatada para o tipo long
	 * @param input String formatada em instância de tempo
	 * @return retorna um long obtido a partir do input
	 */
	private long hourToMillisecond(String input) {
		if(input == null) {
			return 0;
		}
		String[] tokens = input.split(":");
		long hours = Long.parseLong(tokens[0]);
		long minutes = Long.parseLong(tokens[1]);
		long seconds = Long.parseLong(tokens[2]);
		long milliseconds = seconds*1000 + minutes*60000 + hours*3600000;
		return milliseconds;
	}
	
	/**
	 * Método usado para converter um tipo long para uma String no formato instância de tempo
	 * @param milliseconds long a ser convertido
	 * @return retorna uma String obtida a partir do long milliseconds
	 */
	private String millisecondToHour(long milliseconds) {
		int hours = (int) (milliseconds/3600000);
		milliseconds -= hours*3600000;
		int minutes = (int) (milliseconds/60000);
		milliseconds -= minutes*60000;
		int seconds = (int) (milliseconds/1000);
		return hours + ":" + minutes + ":" + seconds;
	}
	
	/**
	 * Pausa o contador de tempo para a simulação
	 */
	public void pause() {
		paused = true;
		runner.interrupt();
		first = null;
	}
	
	/**
	 * Retoma o contador de tempo para a simulação
	 */
	public void play() {
		paused = false;
		start();
	}
	
	/**
	 * Encerra o contador de tempo da simulação
	 */
	public void stop() {
		paused = false;
		runner.interrupt();
		first = null;
		current = null;
	}
	
	public boolean isPaused() {
		return paused;
	}

	public String getTime() {
		return millisecondToHour(time+total);
	}
	
}
