package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ponto de partida de tudo o sistema.
 */
public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Jogo da Vida do Conway");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTitle.setBounds(493, 11, 392, 45);
		contentPane.add(lblTitle);
		
		JButton btnEnter = new JButton("Entrar");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignIn().setVisible(true);
			}
		});
		btnEnter.setBounds(625, 101, 110, 51);
		contentPane.add(btnEnter);
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.setFocusable(false);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp().setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(607, 173, 143, 45);
		contentPane.add(btnRegister);
		
		JButton btnExit = new JButton("Sair");
		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(625, 237, 110, 45);
		contentPane.add(btnExit);
	}
}
