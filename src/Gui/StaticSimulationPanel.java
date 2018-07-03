package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Business.CellNotInstantiatedException;
import Business.Game;
import Business.SimulationControl;
import Business.StaticGridSize.StaticSimulationControl;

import javax.swing.JSlider;

public class StaticSimulationPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private StaticSimulationControl sim;
	private boolean paused;
	private int cellSide;
	private JLabel timer;
	private JLabel generation;
	private JLabel velocity;
	private JSlider slider;
	private JButton pauseButton;
	
	public StaticSimulationPanel() {
		
		setLayout(null);
		setBackground(Color.GRAY);
		
		this.sim = Game.getInstance().getStaticSimulation();
		setCellSide(10);
		
		paused = false;
		pauseButton = new JButton("Pause");
		pauseButton.setFocusable(false);
		pauseButton.setBounds(sim.getCellControl().getColumns()*10+10, 130, 100, 20);
		//add(pauseButton);
		
		timer = new JLabel();
		timer.setBounds(sim.getCellControl().getColumns()*10+10, 0, 100, 40);
		add(timer);
		
		generation = new JLabel();
		generation.setBounds(sim.getCellControl().getColumns()*10+10, 30, 200, 40);
		add(generation);
		
		velocity = new JLabel();
		velocity.setBounds(sim.getCellControl().getColumns()*10+10, 60, 100, 40);
		add(velocity);
		
		slider = new JSlider();
		slider.setBounds(sim.getCellControl().getColumns()*10+10, 100, 100, 20);
		slider.setMaximum((int) SimulationControl.MAX_VELOCITY-1);
		slider.setMinimum(1);
		slider.setValue((int) (SimulationControl.MAX_VELOCITY/2)-1);
		slider.setBackground(Color.LIGHT_GRAY);
		add(slider);
		
		repaint();
		
	}
	
	public void run() {
		sim.getRuntime().play();
		while(!paused) {
			timer.setText("Time: " + sim.getRuntime().getTime());
			generation.setText("Generation: " + sim.getGeneration());
			int vel = (int) ((SimulationControl.MAX_VELOCITY - sim.getVelocity())/10);
			vel += 1;
			velocity.setText("Velocity: " 
			+ vel + "%");
			repaint();
			try {
				sim.selection();
			}catch (CellNotInstantiatedException e) {
				e.printStackTrace();
			}
			sim.setVelocity(slider.getValue());
			try {
				Thread.sleep(sim.getVelocity());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setCellSide(int cellSide) {
		this.cellSide = cellSide;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.LIGHT_GRAY);
		
		BasicStroke bs = new BasicStroke(1.0f);
		g2d.setStroke(bs);
		
		boolean alive = false;
		
		for(int i=0;i<sim.getCellControl().getRows();i++) {
			for(int j=0;j<sim.getCellControl().getColumns();j++) {
				try {
					alive = sim.getCellControl().isAlive(j, i);
				} catch (CellNotInstantiatedException e) {
					e.printStackTrace();
				}
				if(alive) {
					g2d.setColor(Color.BLACK);
					g2d.fillRect(j*cellSide, i*cellSide, cellSide, cellSide);
					g2d.setColor(Color.LIGHT_GRAY);
				}else {
					g2d.drawRect(j*cellSide, i*cellSide, cellSide, cellSide);
				}
			}
		}
		
	}
}
