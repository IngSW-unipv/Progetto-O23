package View.direttore;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import Controller.direttore.LogoutDirML;
import Model.direttore.Direttore;
//import View.AccountCl;
import View.Benvenuto_Form;
import View.cliente.AccountCl;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundImage;


public class DirettoreGUI extends JFrame{
	public JPanel contentPane;
	private JLabel lblCl;
	private static int id;
	private static Direttore dir;
	private JPanel stanze;
	private JPanel dip;
	private JPanel turni;

	public DirettoreGUI(int id,Direttore dir){
		this.id = id;
		this.dir = dir;
		
		turni = new LavTurniPanel(getDir());
		turni.setVisible(false);
		
		stanze = new StanzePanel();
		stanze.setVisible(false);
		
		dip = new LavoratoriPanel(getDir());
		dip.setVisible(false);
		 
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		contentPane = new JPanel();
		contentPane.setBackground((new Color(181,247,157)));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{258, 500, 30, 53};
		gbl_contentPane.rowHeights = new int[]{530, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		GridBagConstraints gbc_stanze = new GridBagConstraints();
		gbc_stanze.insets = new Insets(0, 0, 5, 5);
		gbc_stanze.gridy = 0;
		gbc_stanze.fill = GridBagConstraints.BOTH;
		gbc_stanze.gridx = 1;
		contentPane.add(stanze, gbc_stanze);
		
		GridBagConstraints gbc_dip = new GridBagConstraints();
		gbc_dip.insets = new Insets(0, 0, 5, 5);
		gbc_dip.gridy = 0;
		gbc_dip.fill = GridBagConstraints.BOTH;
		gbc_dip.gridx = 1;
		contentPane.add(dip, gbc_dip);
		
		GridBagConstraints gbc_turni = new GridBagConstraints();
		gbc_turni.insets = new Insets(0, 0, 5, 5);
		gbc_turni.gridy = 0;
		gbc_turni.fill = GridBagConstraints.BOTH;
		gbc_turni.gridx = 1;
		contentPane.add(turni, gbc_turni);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(102, 204, 102));
		GridBagConstraints gbc_paneMenu = new GridBagConstraints();
		gbc_paneMenu.gridheight = 2;
		gbc_paneMenu.fill = GridBagConstraints.BOTH;
		gbc_paneMenu.insets = new Insets(0, 0, 0, 5);
		gbc_paneMenu.gridx = 0;
		gbc_paneMenu.gridy = 0;
		contentPane.add(paneMenu, gbc_paneMenu);
		GridBagLayout gbl_paneMenu = new GridBagLayout();
		gbl_paneMenu.columnWidths = new int[]{248, 0};
		gbl_paneMenu.rowHeights = new int[]{135, 0, 10, 0, 30, 30, 30, 30, 30, 30, 0};
		gbl_paneMenu.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_paneMenu.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		paneMenu.setLayout(gbl_paneMenu);
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(DirettoreGUI.class.getResource("/logo/Senza titolo.png")));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.fill = GridBagConstraints.VERTICAL;
		gbc_lblLogo.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogo.gridx = 0;
		gbc_lblLogo.gridy = 0;
		paneMenu.add(lblLogo, gbc_lblLogo);
		
		JLabel lblNewLabel_1 = new JLabel("Business");
		lblNewLabel_1.setFont(new Font("Yuppy SC", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		paneMenu.add(lblNewLabel_1, gbc_lblNewLabel_1);
		JPanel paneLav = new JPanel();
		paneLav.addMouseListener(new PanelMouse(paneLav)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				
				init();
				turni.setVisible(true);
			}
		});
		GridBagConstraints gbc_paneLav = new GridBagConstraints();
		gbc_paneLav.insets = new Insets(0, 0, 5, 0);
		gbc_paneLav.gridx = 0;
		gbc_paneLav.gridy = 4;
		paneMenu.add(paneLav, gbc_paneLav);
		paneLav.setBackground(new Color(102, 204, 102));
		paneLav.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblLav = new JLabel("Turni dipendenti");
		paneLav.add(lblLav);
		lblLav.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel paneSt = new JPanel();
		paneSt.addMouseListener(new PanelMouse(paneSt){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				init();
				stanze.setVisible(true);
			}
		});
		GridBagConstraints gbc_paneSt = new GridBagConstraints();
		gbc_paneSt.insets = new Insets(0, 0, 5, 0);
		gbc_paneSt.gridx = 0;
		gbc_paneSt.gridy = 5;
		paneMenu.add(paneSt, gbc_paneSt);
		paneSt.setBackground(new Color(102, 204, 102));
		paneSt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblSt = new JLabel("Stato stanze");
		paneSt.add(lblSt);
		
		lblSt.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JPanel panelElAcc = new JPanel();
		panelElAcc.setToolTipText("Elimina Account");
		
		panelElAcc.setBackground(new Color(102, 204, 102));
		GridBagConstraints gbc_panelElAcc = new GridBagConstraints();
		gbc_panelElAcc.insets = new Insets(0, 0, 5, 0);
		gbc_panelElAcc.gridx = 0;
		gbc_panelElAcc.gridy = 6;
		paneMenu.add(panelElAcc, gbc_panelElAcc);
		panelElAcc.setBackground(new Color(102, 204, 102));
		panelElAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblElAcc = new JLabel("Elimina account");
		lblElAcc.setFont(new Font("Thonburi", Font.PLAIN, 16));
		panelElAcc.add(lblElAcc);
		panelElAcc.addMouseListener(new PanelMouse(panelElAcc) {
			@Override
			//chiedo conferma eliminazione e richiamo il form benvenuto
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare il tuo account?") == 0) {
					Benvenuto_Form ben = new Benvenuto_Form();
					ben.setVisible(true);
					DirettoreGUI.this.dispose();
				}
			}
		});
		
		JPanel paneLav2 = new JPanel();
		GridBagConstraints gbc_paneLav2 = new GridBagConstraints();
		paneLav2.setBackground(new Color(102, 204, 102));
		paneLav2.setFont(new Font("Thonburi", Font.PLAIN, 16));
		gbc_paneLav2.insets = new Insets(0, 0, 5, 0);
		gbc_paneLav2.fill = GridBagConstraints.VERTICAL;
		gbc_paneLav2.gridx = 0;
		gbc_paneLav2.gridy = 3;
		paneMenu.add(paneLav2, gbc_paneLav2);
		paneLav2.addMouseListener(new PanelMouse(paneLav2){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				init();
				dip.setVisible(true);
			}
		});
		
		JLabel lblLav2 = new JLabel("Dipendenti");
		lblLav2.setFont(new Font("Thonburi", Font.PLAIN, 16));
		paneLav2.add(lblLav2);
		
		JPanel paneOut = new JPanel();
		paneOut.addMouseListener(new PanelMouse(paneOut) {
			@Override
			//chiedo conferma logout e richiamo il form benvenuto
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0) {
					JOptionPane opzione = null;
					LogoutDirML dirOut = new LogoutDirML(opzione, dir);	
					dirOut.actionPerformed(e);
					DirettoreGUI.this.dispose();
				}
			}
		});
		GridBagConstraints gbc_paneOut = new GridBagConstraints();
		gbc_paneOut.fill = GridBagConstraints.VERTICAL;
		gbc_paneOut.insets = new Insets(0, 0, 5, 0);
		gbc_paneOut.gridx = 0;
		gbc_paneOut.gridy = 7;
		paneMenu.add(paneOut, gbc_paneOut);
		paneOut.setBackground(new Color(102, 204, 102));
		paneOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
		JLabel lblOut = new JLabel("Logout");
		lblOut.setBounds(96, 6, 55, 23);
		paneOut.add(lblOut);
		lblOut.setFont(new Font("Thonburi", Font.PLAIN, 16));
    	
    	JLabel lblNewLabel = new JLabel("Id:");
    	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
    	gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
    	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
    	gbc_lblNewLabel.gridx = 2;
    	gbc_lblNewLabel.gridy = 0;
    	contentPane.add(lblNewLabel, gbc_lblNewLabel);
    	lblNewLabel.setFont(new Font("Thonburi", Font.PLAIN, 12));
    	
    	JLabel lblCl_1 = new JLabel();
    	lblCl_1.setText(String.valueOf(id));
    	GridBagConstraints gbc_lblCl_1 = new GridBagConstraints();
    	gbc_lblCl_1.insets = new Insets(0, 0, 5, 0);
    	gbc_lblCl_1.anchor = GridBagConstraints.NORTHWEST;
    	gbc_lblCl_1.gridx = 3;
    	gbc_lblCl_1.gridy = 0;
    	contentPane.add(lblCl_1, gbc_lblCl_1);
    	setVisible(true);
	}
	
	public static Direttore getDir() {
		return dir;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel getLbl() {
		return lblCl;
	}
	
	public void setLbl(JLabel lblcl) {
		this.lblCl = lblcl;
	}
	
	public void init() {
		turni.setVisible(false);
		dip.setVisible(false);
		stanze.setVisible(false);
	}
	
	private class PanelMouse extends MouseAdapter {
		JPanel contentPane;
		public PanelMouse(JPanel contentPane) {
			this.contentPane=contentPane;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			contentPane.setBackground(new Color(0, 153, 51));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			contentPane.setBackground(new Color(102, 204, 102));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			contentPane.setBackground(new Color(0, 153, 51));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			contentPane.setBackground(new Color(0, 153, 51));
		}
		
	}
	
}