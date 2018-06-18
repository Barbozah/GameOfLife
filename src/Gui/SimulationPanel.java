package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Business.Simulation;

public class SimulationPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Simulation sim;
	private int cellSide;
	
	public SimulationPanel(Simulation sim) {
		
		setBackground(Color.GRAY);
		this.sim = sim;
		setCellSide(10);
		repaint();
		
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
		
		for(int i=0;i<sim.getRows();i++) {
			for(int j=0;j<sim.getColumns();j++) {
				if(sim.getCell(j, i).isAlive()) {
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
