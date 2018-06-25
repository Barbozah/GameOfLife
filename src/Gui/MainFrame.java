package Gui;

import javax.swing.JFrame;

import Business.Game;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		Game.getInstance().action(4, 3);
		Game.getInstance().action(5, 3);
		Game.getInstance().action(6, 3);
		
		SimulationPanel simP = new SimulationPanel();
		setContentPane(simP);
		simP.run();
	}
	
}
