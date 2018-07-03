package Gui;

import javax.swing.JFrame;

import Business.CellNotInstantiatedException;
import Business.Game;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		try {
			Game.getInstance().action(4, 3);
			Game.getInstance().action(5, 3);
			Game.getInstance().action(6, 3);
		}catch (CellNotInstantiatedException e) {
			e.printStackTrace();
		}
		
		StaticSimulationPanel simP = new StaticSimulationPanel();
		setContentPane(simP);
		simP.run();
	}
	
}
