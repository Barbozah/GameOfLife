package Gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Player;
import Persistence.PersistenceFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

/**
 * Frame que captura o login do usuário e cadastrá-o.
 * @author Antonio
 */
public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JButton btnConfirm;
	private JButton btnCancel;

	public SignUp() {
		setBounds(100, 100, 1300, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Informe o nome de usu\u00E1rio e a senha para cadastrar");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitle.setBounds(300, 11, 800, 38);
		contentPane.add(lblTitle);
		
		JLabel lblNotifications = new JLabel("");
		lblNotifications.setBounds(829, 167, 200, 23);
		contentPane.add(lblNotifications);
		
		JLabel lblUserNotification = new JLabel("");
		lblUserNotification.setBounds(562, 151, 254, 14);
		contentPane.add(lblUserNotification);
		
		JLabel lblPasswordNotification = new JLabel("");
		lblPasswordNotification.setBounds(562, 205, 254, 14);
		contentPane.add(lblPasswordNotification);
		
		JLabel lblUser = new JLabel("Usu\u00E1rio:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUser.setBounds(440, 165, 88, 29);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Senha:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(440, 217, 88, 29);
		contentPane.add(lblPassword);
		
		textFieldUser = new JTextField();
		textFieldUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.requestFocus();
			}
		});
		textFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUser.setBounds(562, 165, 254, 29);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirm.requestFocus();
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(562, 218, 254, 29);
		contentPane.add(passwordField);
		char echo = passwordField.getEchoChar();
		
		JCheckBox chckbxPassword = new JCheckBox("Mostrar Senha");
		chckbxPassword.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					passwordField.setEchoChar((char) 0);
				}else {
					passwordField.setEchoChar(echo);
				}
			}
		});
		chckbxPassword.setBounds(834, 217, 116, 29);
		contentPane.add(chckbxPassword);
		
		btnConfirm = new JButton("Cadastrar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldUser.getText();
				String password = String.copyValueOf(passwordField.getPassword());
				if(!name.equals("") && !password.equals("")) {
					PersistenceFacade.getInstance().register(new Player(name, password));
					lblNotifications.setForeground(new Color(0, 128, 0));
					lblNotifications.setText("Usu\u00E1rio cadastrado com sucesso!");
					textFieldUser.setText("");
					passwordField.setText("");
					lblUserNotification.setText("");
					lblPasswordNotification.setText("");
				}else {
					lblNotifications.setForeground(new Color(128, 0, 0));
					lblNotifications.setText("Erro ao tentar cadastrar usu\u00E1rio!");
					if(name.equals("")) {
						lblUserNotification.setForeground(new Color(128, 0, 0));
						lblUserNotification.setText("Usu\u00E1rio n\u00E3o pode conter valor nulo");
					}else {
						lblUserNotification.setText("");
					}
					if(password.equals("")) {
						lblPasswordNotification.setForeground(new Color(128, 0, 0));
						lblPasswordNotification.setText("Senha n\u00E3o pode conter valor nulo");
					}else {
						lblPasswordNotification.setText("");
					}
				}
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirm.setBounds(527, 294, 137, 45);
		contentPane.add(btnConfirm);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(697, 294, 137, 45);
		contentPane.add(btnCancel);
		
	}
}
