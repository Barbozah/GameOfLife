package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("Bem vindo");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcome.setBounds(142, 11, 117, 29);
		add(lblWelcome);
		
		JButton btnNovaSimulao = new JButton("Nova Simula\u00E7\u00E3o");
		btnNovaSimulao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNovaSimulao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNovaSimulao.setBounds(142, 84, 117, 23);
		add(btnNovaSimulao);
		
		JButton btnAbrirSimulao = new JButton("Abrir Simula\u00E7\u00E3o");
		btnAbrirSimulao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAbrirSimulao.setBounds(142, 130, 117, 23);
		add(btnAbrirSimulao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(154, 176, 89, 23);
		add(btnSair);

	}
}
