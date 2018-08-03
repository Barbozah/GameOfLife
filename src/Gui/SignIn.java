package Gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Player;
import Persistence.CellRepositoryControl;
import Persistence.PermissionDeniedException;
import Persistence.PersistenceFacade;
import Persistence.PlayerNotFoundException;
import Persistence.UserData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JLabel lblSelect;
	private JComboBox<String> comboBoxSelect;
	private JButton btnComboConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setBounds(100, 100, 1300, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSelect = new JLabel("Escolha um arquivo:");
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelect.setBounds(592, 388, 180, 38);
		contentPane.add(lblSelect);
		lblSelect.setVisible(false);
		
		comboBoxSelect = new JComboBox<>();
		comboBoxSelect.setBounds(592, 437, 180, 38);
		contentPane.add(comboBoxSelect);
		comboBoxSelect.setVisible(false);
		
		btnComboConfirm = new JButton("Ok");
		btnComboConfirm.setBounds(592, 500, 180, 38);
		contentPane.add(btnComboConfirm);
		btnComboConfirm.setVisible(false);
		
		JLabel lblTitle = new JLabel("Informe nome e senha de um usu\u00E1rio cadastrado");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitle.setBounds(327, 11, 800, 38);
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
		
		btnConfirm = new JButton("Entrar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldUser.getText();
				String password = String.copyValueOf(passwordField.getPassword());
				if(!name.equals("") && !password.equals("")) {
					try {
						Player player = new Player(name, password);
						UserData data = PersistenceFacade.getInstance().search(player);
						lblNotifications.setForeground(new Color(0, 128, 0));
						lblNotifications.setText("Usu\u00E1rio encontrado!");
						if(data.getData().isEmpty()) {
							if(JOptionPane.showConfirmDialog(null, "Usu\u00E1rio não possue arquivos salvos, deseja iniciar um novo?", "", JOptionPane.ERROR_MESSAGE) == 1) {
								lblNotifications.setForeground(new Color(128, 0, 0));
								lblNotifications.setText("Tente ou usu\u00E1rio");
							}else {
								new SimulationFrame(data).setVisible(true);
							}
						}else {
							selectData(data);
						}
					} catch (PlayerNotFoundException e1) {
						lblNotifications.setForeground(new Color(128, 0, 0));
						lblNotifications.setText("Usu\u00E1rio n\u00E3o encontrado!");
						if(JOptionPane.showConfirmDialog(null, "Deseja mostrar o caminho para o arquivo?", "", JOptionPane.ERROR_MESSAGE) == 1) {
							lblNotifications.setForeground(new Color(128, 0, 0));
							lblNotifications.setText("Tente outro usu\u00E1rio");
						}else {
							JFileChooser jfc = new JFileChooser();
							jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
							if(jfc.showOpenDialog(getContentPane()) == 1) {
								lblNotifications.setForeground(new Color(128, 0, 0));
								lblNotifications.setText("Tente outro usu\u00E1rio");
							}else {
								File arq = jfc.getSelectedFile();
								try {
									PersistenceFacade.getInstance().getRepository().restore(arq.getPath(), new Player(name, password));
								} catch (ClassNotFoundException | IOException e2) {
									lblNotifications.setForeground(new Color(128, 0, 0));
									lblNotifications.setText("Arquivo inválido!");
								} catch (PermissionDeniedException e2) {
									lblNotifications.setForeground(new Color(128, 0, 0));
									lblNotifications.setText("Permissão negada para: " + e2.getName());
								} catch (PlayerNotFoundException e2) {
									e2.printStackTrace();
								}
								lblNotifications.setForeground(new Color(0, 128, 0));
								lblNotifications.setText("Usuario recuperado!");
							}
						}
					}
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
	
	private void selectData(UserData data) {
		lblSelect.setVisible(true);
		comboBoxSelect.setVisible(true);
		btnComboConfirm.setVisible(true);
		btnComboConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SimulationFrame(data).setVisible(true);
			}
		});
		for (CellRepositoryControl s : data.getData()) {
			comboBoxSelect.addItem(s.createdIn());
		}
		comboBoxSelect.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				data.setSelectedIndex(e.getStateChange());
				new SimulationFrame(data).setVisible(true);
			}
		});
	}
}
