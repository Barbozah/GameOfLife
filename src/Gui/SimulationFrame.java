package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Business.BusinessFacade;
import Business.Player;
import Persistence.UserData;

public class SimulationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationFrame frame = new SimulationFrame(new UserData(new Player("1", "1")));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimulationFrame(UserData data) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(0, 0, 1380, 900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		BusinessFacade.setInstance(200, 200, data);
		SimulationPanel simPanel = new SimulationPanel();
		setContentPane(simPanel);
		simPanel.setVisible(true);
		new Thread(simPanel).start();
	}

}
