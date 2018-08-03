package Gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import Business.BusinessFacade;
import Business.SimulationControl;
import Persistence.CellNotInstantiatedException;
import Persistence.PersistenceFacade;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * Painel onde a simulação é excutada e ilustrada.
 * @author Antonio
 */
public class SimulationPanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private SimulationControl sim;
	private int cellHeight;
	private int cellWidth;
	private JLabel lblTimer;
	private JLabel lblGeneration;
	private JLabel lblVelocity;
	private JSlider sliderDelay;
	private JButton btnPause;
	private JComboBox<Integer> comboBoxScale;
	private JComboBox<String> comboBoxBehavior;
	private JLabel lblScale;
	private JLabel lblBehavior;
	private JButton btnSalvar;
	
	public SimulationPanel() {
		
		this.sim = BusinessFacade.getInstance().getSimCurrent();
		
		setCellHeight(5);
		setCellWidth(5);
		sim.getCellControl().setIdealDimention(5);
		
		setLayout(null);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (sim.isPaused()
						&& e.getX() / cellWidth < sim.getCellControl().getColumns()
						&& e.getY() / cellHeight < sim.getCellControl().getRows()) {
					try {
						BusinessFacade.getInstance().action(e.getX() / cellWidth, e.getY() / cellHeight);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				if (sim.isPaused()
						&& e.getX() / cellWidth < sim.getCellControl().getColumns()
						&& e.getY() / cellHeight < sim.getCellControl().getRows()) {
					try {
						BusinessFacade.getInstance().action(e.getX() / cellWidth, e.getY() / cellHeight);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(1100, 0, 270, 749);
		add(panel);
		panel.setLayout(null);
		
		lblTimer = new JLabel("Tempo: 00:00:00");
		lblTimer.setFont(new Font("Serif", Font.PLAIN, 24));
		lblTimer.setBounds(24, 24, 163, 25);
		panel.add(lblTimer);
		
		lblGeneration = new JLabel("Gera\u00E7\u00E3o: 0");
		lblGeneration.setFont(new Font("Serif", Font.PLAIN, 24));
		lblGeneration.setBounds(24, 68, 236, 25);
		panel.add(lblGeneration);
		
		lblVelocity = new JLabel("Delay: 50%");
		lblVelocity.setFont(new Font("Serif", Font.PLAIN, 24));
		lblVelocity.setBounds(24, 114, 195, 25);
		panel.add(lblVelocity);
		
		sliderDelay = new JSlider();
		sliderDelay.setBounds(24, 153, 200, 26);
		sliderDelay.setMaximum((int) SimulationControl.MAX_VELOCITY);
		sliderDelay.setMinimum(0);
		sliderDelay.setValue(500);
		panel.add(sliderDelay);
		
		btnPause = new JButton("Retomar");
		btnPause.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sim.isPaused()) {
					btnPause.setText("Pausar");
					sim.play();
				} else {
					btnPause.setText("Retomar");
					sim.pause();
					sim.getRuntime().pause();
				}

			}
		});
		btnPause.setBounds(47, 309, 153, 54);
		panel.add(btnPause);
		
		comboBoxScale = new JComboBox<Integer>();
		comboBoxScale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int scale = (int)e.getItem();
				sim.getCellControl().setIdealDimention(scale);
				setCellHeight(scale);
				setCellWidth(scale);
			}
		});
		comboBoxScale.addItem(5);
		comboBoxScale.addItem(10);
		comboBoxScale.addItem(20);
		comboBoxScale.addItem(50);
		comboBoxScale.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBoxScale.setBounds(108, 207, 116, 26);
		panel.add(comboBoxScale);
		
		lblScale = new JLabel("Escala:");
		lblScale.setFont(new Font("Serif", Font.PLAIN, 24));
		lblScale.setBounds(24, 208, 69, 25);
		panel.add(lblScale);
		
		lblBehavior = new JLabel("A\u00E7\u00E3o:");
		lblBehavior.setFont(new Font("Serif", Font.PLAIN, 24));
		lblBehavior.setBounds(24, 255, 57, 26);
		panel.add(lblBehavior);
		
		comboBoxBehavior = new JComboBox<String>();
		comboBoxBehavior.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBoxBehavior.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String sel = (String) e.getItem();
				switch (sel) {
					case "Matar":
						BusinessFacade.getInstance().getSimCurrent().setCursorBehavior(false);
						break;
					case "Reviver":
						BusinessFacade.getInstance().getSimCurrent().setCursorBehavior(true);
						break;
				}
			}
		});
		comboBoxBehavior.addItem("Reviver");
		comboBoxBehavior.addItem("Matar");
		comboBoxBehavior.setBounds(108, 255, 116, 27);
		panel.add(comboBoxBehavior);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if(jfc.showSaveDialog(null) == 1) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo", "", JOptionPane.ERROR_MESSAGE);
				}else {
					File arq = jfc.getSelectedFile();
					try {
						BusinessFacade.getInstance().saveData();
						PersistenceFacade.getInstance().getRepository().save(arq.getAbsolutePath(), BusinessFacade.getInstance().getDataCurrent());
						JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo", "", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSalvar.setBounds(47, 388, 153, 54);
		panel.add(btnSalvar);
		repaint();
	}
	
	public void setCellHeight(int cellHeight) {
		this.cellHeight = cellHeight;
	}

	/**
	 * 
	 * @param cellWidth
	 */
	public void setCellWidth(int cellWidth) {
		this.cellWidth = cellWidth;
	}
	@Override
	public void run() {
		sim.getRuntime().play();
		lblTimer.setText("Tempo: " + sim.getRuntime().getTime());
		
		while (true) {
			lblGeneration.setText("Geração: " + sim.getGeneration());
			int vel = (int) sim.getVelocity();
			lblVelocity.setText("Delay: " + vel + "%");
			repaint();
			if (!sim.isPaused()) {
				sim.getRuntime().play();
				lblTimer.setText("Tempo: " + sim.getRuntime().getTime());
				try {
					sim.selection();
				} catch (CellNotInstantiatedException e) {
					e.printStackTrace();
				}
			}
			sim.setVelocity(sliderDelay.getValue());
			try {
				Thread.sleep(sim.getVelocity());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.LIGHT_GRAY);

		BasicStroke bs = new BasicStroke(1.0f);
		g2d.setStroke(bs);

		boolean alive = false;
		for (int i = 0; i < sim.getCellControl().getRows(); i++) {
			for (int j = 0; j < sim.getCellControl().getColumns(); j++) {
				try {
					alive = sim.getCellControl().isAlive(j, i);
				} catch (CellNotInstantiatedException e) {
					e.printStackTrace();
				}
				if (alive) {
					g2d.setColor(Color.BLACK);
					g2d.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
					g2d.setColor(Color.LIGHT_GRAY);
				} else {
					g2d.drawRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
				}
			}
		}
	}
}
