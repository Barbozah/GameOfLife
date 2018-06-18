package Gui;

import javax.swing.JFrame;

import Business.Game;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		Game g = new Game();
		
		g.action(4, 3);
		g.action(5, 3);
		g.action(6, 3);
		
		setContentPane(new SimulationPanel(g.getSimCurrent()));
	}
	
}
