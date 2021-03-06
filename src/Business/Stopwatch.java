package Business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Stopwatch {
	
	private Timer timer;
	private boolean paused;
	private long current;
	
	public Stopwatch() {
		paused = true;
		this.run();
	}
	
	/**
	 * Executa as a��es necessarias para o tempo correr
	 */
	private void run() {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!paused) {
					current++;
				}
			}
		};
		timer = new Timer(1000, action);
		timer.start();
	}
	
	/**
	 * Zera o tempo
	 */
	public void reset() {
		current = 0;
	}
	
	/**
	 * @return Status do tempo
	 */
	public boolean isPaused() {
		return paused;
	}
	
	/**
	 * Retoma o tempo
	 */
	public void play() {
		paused = false;
	}
	
	/**
	 * Pausa o tempo
	 */
	public void pause() {
		paused = true;
	}
	
	/**
	 * @return String com o tempo atual
	 */
	public String getTime() {
		int hours = (int) (current/3600);
		int minutes = (int) (current/60 - hours*60);
		int seconds = (int) (current - minutes*60 - hours*3600);
		String hoursString = hours + "";
		String minutesString = minutes + "";
		String secondsString = seconds + "";
		if(hours < 10) {
			hoursString = "0" + hours;
		}
		if(minutes < 10) {
			minutesString = "0" + minutes;
		}
		if(seconds < 10) {
			secondsString = "0" + seconds;
		}
		return hoursString + ":" + minutesString + ":" + secondsString;
	}
}
