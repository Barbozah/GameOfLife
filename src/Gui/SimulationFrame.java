package Gui;

import javax.swing.JFrame;

import Business.BusinessFacade;
import Persistence.UserData;

/**
 * Frame que inicia o painel de simulação.
 * @author Antonio
 */
public class SimulationFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public SimulationFrame(UserData data) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1380, 900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		BusinessFacade.setInstance(200, 200, data);
		SimulationPanel simPanel = new SimulationPanel();
		simPanel.setVisible(true);
		setContentPane(simPanel);
		new Thread(simPanel).start();
	}

}
