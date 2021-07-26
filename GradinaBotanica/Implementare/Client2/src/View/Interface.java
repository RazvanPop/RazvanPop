package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.CautareDenumirePlanta;
import Controller.HistogramPanel;
import Controller.PlantaOp;
import Controller.Subject;
import Controller.VizualizarePlante;
import Controller.Observer;
import Model.Admin;
import Model.AdminConnection;
import Model.Angajat;
import Model.AngajatConnection;
import Model.Planta;
import Model.PlantaConnection;

public class Interface extends Observer {
	
	//VizitatorView
	private JFrame frame;
	private javax.swing.JButton btnVizualizarePlante;
	private javax.swing.JLabel lblVizitator;	
	private javax.swing.JButton btnSortarePlante;
	private javax.swing.JButton btnCautarePlante;
	private javax.swing.JButton btnVizualizareStatistici;
	private javax.swing.JButton btnLogIn;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	
	//LoginView
	private JFrame frame1;
	private JTextField textField;
	private JTextField textField_1;
	public  JLabel lblLogin;
	public  JLabel lblUsername;
	public  JLabel lblPassword;
	public  JButton btnConnection;
	public  JButton btnNewButton;
	
	//AngajatView
	private JFrame frame2;
	private JLabel lblAngajat;
	private JButton btnInserare;
	private JButton btnStergerePlanta;
	private JButton btnUpdatePlanta; 
	private JButton btnSalvareRaport;
	
	//InsearePlantaView
	private JFrame frame3;
	private JTextField textFieldI;
	private JTextField textField_1I;
	private JTextField textField_2I;
	private JTextField textField_3I;
	private JTextField textField_4I;
	private JLabel lblInserarePlanta;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButtonI;
	
	//StergerePlantaView
	private JFrame frame4;
	private JTextField textFieldS;
	private JLabel lblNewLabelS;
	private JLabel lblNewLabel_1S;
	private JButton btnNewButtonS;
	
	//UpdatePlanta
	private JFrame frame5;
	private JTextField textFieldU;
	private JTextField textField_1U;
	private JTextField textField_2U;
	private JTextField textField_3U;
	private JTextField textField_4U;
	//private JLabel lblInserarePlanta;
	private JLabel lblNewLabelU;
	private JLabel lblNewLabel_1U;
	private JLabel lblNewLabel_2U;
	private JLabel lblNewLabel_3U;
	private JLabel lblNewLabel_4U;
	private JLabel lblNewLabel_5U;
	private JButton btnNewButtonU;
	
	//AdminView
	private JFrame frame6;
	private JLabel lblAdmin;
	private JButton btnInserareAngajat;
	private JButton btnStergereAngajat;
	private JButton btnUpdateAngajat;
	
	//InsertAngajatView
	private JFrame frame7;
	private JLabel lblInserareAngajat;
	private JTextField	textFieldQ;
	private JTextField	textField_1Q;
	private JTextField	textField_2Q;
	private JButton btnNewButtonQ;
	private JLabel lblNewLabelQ;
	private JLabel lblNewLabel_1Q;
	private JLabel lblNewLabel_2Q;
	
	//EditareAngajatView
	private JFrame frame8;
	private JLabel lblUpdateEmployee8;
	private JTextField textField8 ;
	private JTextField textField_28 ;
	private JTextField textField_38 ;
	private JLabel lblNewLabel8;
	private JLabel lblNewLabel_18;
	private JLabel lblNume8;
	private JButton btnNewButton8;
	
	//StergereAngajatView
	private JFrame frame9;
	private JLabel lblNewLabel9;
	private JTextField textField9;
	private JLabel lblNume9;
	private JButton btnNewButton9;
	
	private Subject s = new Subject();
	private Subject s2 = new Subject();
	private Subject s3 = new Subject();
	
	public Interface()
	{
		//Vizitator
	frame = new JFrame();
	frame.setBounds(100, 100, 900, 685);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	frame.setVisible(true);
	
	lblVizitator = new JLabel("Vizitator");
	lblVizitator.setFont(new Font("Tahoma", Font.BOLD, 40));
	lblVizitator.setHorizontalAlignment(SwingConstants.CENTER);
	lblVizitator.setBounds(182, 34, 415, 76);
	frame.getContentPane().add(lblVizitator);
	
	btnVizualizarePlante = new JButton("Vizualizare plante");
	btnVizualizarePlante.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VizualizarePlante q=new VizualizarePlante();
			//VizualizarePlante.main(null);
		}
	});
	btnVizualizarePlante.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnVizualizarePlante.setBounds(180, 159, 430, 53);
	frame.getContentPane().add(btnVizualizarePlante);
	
	btnSortarePlante = new JButton("Sortare plante");
	btnSortarePlante.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			FiltarePlanteView f=new FiltarePlanteView();
			FiltarePlanteView.main(null);
		}
	});
	btnSortarePlante.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnSortarePlante.setBounds(182, 273, 430, 61);
	frame.getContentPane().add(btnSortarePlante);
	
	btnCautarePlante = new JButton("Cautare plante");
	btnCautarePlante.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CautareDenumirePlanta n=new CautareDenumirePlanta();
			CautareDenumirePlanta.main(null);
		}
	});
	btnCautarePlante.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnCautarePlante.setBounds(180, 404, 430, 59);
	frame.getContentPane().add(btnCautarePlante);
	
	btnVizualizareStatistici = new JButton("Vizualizare statistici");
	btnVizualizareStatistici.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			HistogramPanel h=new HistogramPanel();
			HistogramPanel.main(null);
		}
	});
	btnVizualizareStatistici.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnVizualizareStatistici.setBounds(182, 534, 430, 61);
	frame.getContentPane().add(btnVizualizareStatistici);
	
	btnLogIn = new JButton("LOGARE");
	btnLogIn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame1.setVisible(true);
		}
	});
	btnLogIn.setBounds(773, 13, 97, 25);
	frame.getContentPane().add(btnLogIn);
	
	jLabel7 = new javax.swing.JLabel();
	jLabel7.setBounds(773, 53, 97, 25);
	frame.getContentPane().add(jLabel7);
	jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
	jLabel7.setForeground(new java.awt.Color(255, 0, 51));
	jLabel7.setText("Romana");
	jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        	jLabel7MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
			jLabel7MouseEntered(evt);
		}
		public void mouseExited(java.awt.event.MouseEvent evt) {
			jLabel7MouseExited(evt);
		}
    });
	
	
	jLabel8 = new javax.swing.JLabel();
	jLabel8.setBounds(773, 73, 97, 25);
	frame.getContentPane().add(jLabel8);
	jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
	jLabel8.setForeground(new java.awt.Color(255, 0, 51));
	jLabel8.setText("English");
	jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseClicked(java.awt.event.MouseEvent evt) {
			jLabel8MouseClicked(evt);
			//JOptionPane.showMessageDialog(null,"Limba a fost schimbata");
		}
		public void mouseEntered(java.awt.event.MouseEvent evt) {
			jLabel8MouseEntered(evt);
		}
		public void mouseExited(java.awt.event.MouseEvent evt) {
			jLabel8MouseExited(evt);
		}
		});
	
	
	jLabel9 = new javax.swing.JLabel();
	jLabel9.setBounds(773, 93, 97, 25);
	frame.getContentPane().add(jLabel9);
	jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
	jLabel9.setForeground(new java.awt.Color(255, 0, 51));
	jLabel9.setText("German");
	jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
		public void mouseClicked(java.awt.event.MouseEvent evt) {
			jLabel9MouseClicked(evt);
		}
		public void mouseEntered(java.awt.event.MouseEvent evt) {
			jLabel9MouseEntered(evt);
		}
		public void mouseExited(java.awt.event.MouseEvent evt) {
			jLabel9MouseExited(evt);
		}
		});				        

	//Login
	frame1 = new JFrame();
	frame1.setBounds(100, 100, 900, 685);
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.getContentPane().setLayout(null);
	frame1.setVisible(false);
	
	lblLogin = new JLabel("Logare");
	lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogin.setForeground(Color.BLACK);
	lblLogin.setFont(new Font("Tahoma", Font.BOLD, 60));
	lblLogin.setBounds(230, 23, 363, 124);
	frame1.getContentPane().add(lblLogin);
	
	textField = new JTextField();
	textField.setBounds(452, 245, 342, 49);
	frame1.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(452, 352, 342, 49);
	frame1.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	lblUsername = new JLabel("NUME :");
	lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblUsername.setBounds(156, 245, 221, 49);
	frame1.getContentPane().add(lblUsername);
	
	lblPassword = new JLabel("PAROLA :");
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblPassword.setBounds(156, 352, 221, 49);
	frame1.getContentPane().add(lblPassword);
	
	btnConnection = new JButton("Conectare Administrator");
	btnConnection.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Admin> list_admin = new ArrayList<Admin>();
			AdminConnection adop = new AdminConnection();
			list_admin=adop.viewAll();
			for(Admin i:list_admin)
			{
				if(i.getUsername().equals(textField.getText()) && i.getPass().equals(textField_1.getText()))
				{
					//System.out.println(i.toString());
					//AdminView q=new AdminView();
					//AdminView.main(null);
					frame6.setVisible(true);
				}
			}
		}
	});
	btnConnection.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnConnection.setBounds(92, 475, 235, 89);
	frame1.getContentPane().add(btnConnection);
	
	btnNewButton = new JButton("Conectare Angajat");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Angajat> list_angajat = new ArrayList<Angajat>();
			AngajatConnection andop = new AngajatConnection();
			list_angajat=andop.viewAll();
			for(Angajat i:list_angajat)
			{		
				if((i.getUsername().equals(textField.getText())) && (i.getPass().equals(textField_1.getText())))
				{
					//AngajatView q=new AngajatView();
					//AngajatView.main(null);
					frame2.setVisible(true);
				}
			}
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	btnNewButton.setBounds(566, 475, 235, 89);
	frame1.getContentPane().add(btnNewButton);
	
	//AngajatView
	frame2 = new JFrame();
	frame2.setBounds(100, 100, 900, 685);
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.getContentPane().setLayout(null);
	frame2.setVisible(false);
	
	lblAngajat = new JLabel("Angajat");
	lblAngajat.setHorizontalAlignment(SwingConstants.CENTER);
	lblAngajat.setFont(new Font("Tahoma", Font.BOLD, 40));
	lblAngajat.setBounds(264, 13, 408, 57);
	frame2.getContentPane().add(lblAngajat);
	
	btnInserare = new JButton("Inserare planta");
	btnInserare.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//InserarePlantaView nou = new InserarePlantaView();
			//nou.main(null);
			frame3.setVisible(true);
		}
	});
	btnInserare.setBounds(337, 112, 248, 57);
	frame2.getContentPane().add(btnInserare);
	
	btnStergerePlanta = new JButton("Stergere planta");
	btnStergerePlanta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//DeletePlantaView nou = new DeletePlantaView();
			//nou.main(null);
			frame4.setVisible(true);
		}
	});
	btnStergerePlanta.setBounds(337, 262, 248, 57);
	frame2.getContentPane().add(btnStergerePlanta);
	
	btnUpdatePlanta = new JButton("Actualizare planta");
	btnUpdatePlanta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//EditarePlantaView nou = new EditarePlantaView();
			//nou.main(null);
			frame5.setVisible(true);
		}
	});
	btnUpdatePlanta.setBounds(337, 402, 248, 57);
	frame2.getContentPane().add(btnUpdatePlanta);
	
	btnSalvareRaport = new JButton("Salvare raport");
	btnSalvareRaport.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PlantaOp p = new PlantaOp();
			p.PlanteTxt();
			p.PlanteCSV();
		}
	});
	btnSalvareRaport.setBounds(337, 528, 248, 51);
	frame2.getContentPane().add(btnSalvareRaport);
	
	//InserarePlantaView
	frame3 = new JFrame();
	frame3.setBounds(100, 100, 900, 731);
	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame3.getContentPane().setLayout(null);
	frame3.setVisible(false);
	
	lblInserarePlanta = new JLabel("Inserare Planta");
	lblInserarePlanta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	lblInserarePlanta.setBounds(325, 26, 297, 45);
	frame3.getContentPane().add(lblInserarePlanta);
	
	textFieldI = new JTextField();
	textFieldI.setBounds(439, 142, 264, 29);
	frame3.getContentPane().add(textFieldI);
	textFieldI.setColumns(10);
	
	lblNewLabel = new JLabel("Denumire :");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel.setBounds(174, 142, 264, 53);
	frame3.getContentPane().add(lblNewLabel);
	
	lblNewLabel_1 = new JLabel("Tip :");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_1.setBounds(184, 214, 135, 37);
	frame3.getContentPane().add(lblNewLabel_1);
	
	textField_1I = new JTextField();
	textField_1I.setBounds(439, 221, 264, 29);
	frame3.getContentPane().add(textField_1I);
	textField_1I.setColumns(10);
	
	lblNewLabel_2 = new JLabel("Specie :");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_2.setBounds(174, 315, 135, 37);
	frame3.getContentPane().add(lblNewLabel_2);
	
	textField_2I = new JTextField();
	textField_2I.setBounds(439, 315, 264, 29);
	frame3.getContentPane().add(textField_2I);
	textField_2I.setColumns(10);
	
	lblNewLabel_3 = new JLabel("Tip carnivor :");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_3.setBounds(174, 398, 135, 37);
	frame3.getContentPane().add(lblNewLabel_3);
	
	textField_3I = new JTextField();
	textField_3I.setBounds(439, 407, 264, 29);
	frame3.getContentPane().add(textField_3I);
	textField_3I.setColumns(10);
	
	lblNewLabel_4 = new JLabel(" Zona :");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_4.setBounds(174, 511, 227, 36);
	frame3.getContentPane().add(lblNewLabel_4);
	
	textField_4I = new JTextField();
	textField_4I.setBounds(439, 518, 264, 29);
	frame3.getContentPane().add(textField_4I);
	textField_4I.setColumns(10);
	
	btnNewButtonI = new JButton("ADAUGA");
	btnNewButtonI.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PlantaConnection planta = new PlantaConnection();
			Planta p = new Planta(textFieldI.getText(), textField_1I.getText(), textField_2I.getText(), textField_3I.getText(), textField_4I.getText());
			planta.insert(p);
			JOptionPane.showMessageDialog(btnNewButtonI, "Planta adaugata cu succes");
			frame3.dispose();
		}
	});
	btnNewButtonI.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	btnNewButtonI.setBounds(315, 599, 253, 61);
	frame3.getContentPane().add(btnNewButtonI);
	
	//StergerePlantaView
	frame4 = new JFrame();
	frame4.setBounds(100, 100, 900, 685);
	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame4.getContentPane().setLayout(null);
	frame4.setVisible(false);
	
	lblNewLabelS = new JLabel("Stergere Planta");
	lblNewLabelS.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblNewLabelS.setBounds(322, 44, 313, 69);
	frame4.getContentPane().add(lblNewLabelS);
	
	lblNewLabel_1S = new JLabel("Denumire :");
	lblNewLabel_1S.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_1S.setBounds(118, 225, 195, 88);
	frame4.getContentPane().add(lblNewLabel_1S);
	
	textFieldS = new JTextField();
	textFieldS.setBounds(402, 244, 390, 57);
	frame4.getContentPane().add(textFieldS);
	textFieldS.setColumns(10);
	
	btnNewButtonS = new JButton("STERGERE");
	btnNewButtonS.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PlantaConnection planta = new PlantaConnection();
			planta.delete(textFieldS.getText());
			JOptionPane.showMessageDialog(btnNewButtonS, "Planta stearsa cu succes");
			frame4.dispose();
		}
	});
	btnNewButtonS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	btnNewButtonS.setBounds(322, 427, 292, 88);
	frame4.getContentPane().add(btnNewButtonS);

	//UpdatePlantaView
	frame5 = new JFrame();
	frame5.setBounds(100, 100, 900, 751);
	frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame5.getContentPane().setLayout(null);
	frame5.setVisible(false);
	
	lblNewLabelU = new JLabel("Editare Planta");
	lblNewLabelU.setFont(new Font("Tahoma", Font.BOLD, 30));
	lblNewLabelU.setBounds(449, 33, 330, 61);
	frame5.getContentPane().add(lblNewLabelU);
	
	lblNewLabel_1U = new JLabel("Denumire :");
	lblNewLabel_1U.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_1U.setBounds(115, 169, 232, 39);
	frame5.getContentPane().add(lblNewLabel_1U);
	
	lblNewLabel_2U = new JLabel("Tip :");
	lblNewLabel_2U.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_2U.setBounds(115, 251, 232, 39);
	frame5.getContentPane().add(lblNewLabel_2U);
	
	lblNewLabel_3U = new JLabel("Specie :");
	lblNewLabel_3U.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_3U.setBounds(115, 334, 232, 39);
	frame5.getContentPane().add(lblNewLabel_3U);
	
	lblNewLabel_4U = new JLabel("Planta Carnivora :");
	lblNewLabel_4U.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_4U.setBounds(115, 411, 232, 46);
	frame5.getContentPane().add(lblNewLabel_4U);
	
	lblNewLabel_5U = new JLabel("Zona :");
	lblNewLabel_5U.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_5U.setBounds(115, 502, 232, 39);
	frame5.getContentPane().add(lblNewLabel_5U);
	
	textFieldU = new JTextField();
	textFieldU.setBounds(449, 166, 286, 42);
	frame5.getContentPane().add(textFieldU);
	textFieldU.setColumns(10);
	
	textField_1U = new JTextField();
	textField_1U.setBounds(449, 248, 286, 42);
	frame5.getContentPane().add(textField_1U);
	textField_1U.setColumns(10);
	
	textField_2U = new JTextField();
	textField_2U.setBounds(449, 332, 286, 41);
	frame5.getContentPane().add(textField_2U);
	textField_2U.setColumns(10);
	
	textField_3U = new JTextField();
	textField_3U.setBounds(449, 418, 286, 39);
	frame5.getContentPane().add(textField_3U);
	textField_3U.setColumns(10);
	
	textField_4U = new JTextField();
	textField_4U.setBounds(449, 502, 286, 39);
	frame5.getContentPane().add(textField_4U);
	textField_4U.setColumns(10);
	
	btnNewButtonU = new JButton("ACTUALIZARE");
	btnNewButtonU.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PlantaConnection planta = new PlantaConnection();
			Planta p = new Planta(textFieldU.getText(), textField_1U.getText(), textField_2U.getText(), textField_3U.getText(), textField_4U.getText());
			planta.update(p);
			JOptionPane.showMessageDialog(btnNewButton, "Planta modificata cu succes");
			frame5.dispose();
		}
	});
	btnNewButtonU.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	btnNewButtonU.setBounds(449, 598, 248, 93);
	frame5.getContentPane().add(btnNewButtonU);
	
	
	//AdminView
	frame6 = new JFrame();
	frame6.setBounds(100, 100, 900, 685);
	frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame6.getContentPane().setLayout(null);
	frame6.setVisible(false);
	
	lblAdmin = new JLabel("Admin");
	lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 40));
	lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
	lblAdmin.setBounds(281, 32, 360, 64);
	frame6.getContentPane().add(lblAdmin);
	
	btnInserareAngajat = new JButton("Inserare Angajat");
	btnInserareAngajat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//InserareAngajatView nou = new InserareAngajatView();
			//nou.main(null);
			frame7.setVisible(true);
		}
	});
	btnInserareAngajat.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnInserareAngajat.setBounds(348, 188, 230, 56);
	frame6.getContentPane().add(btnInserareAngajat);
	
	btnStergereAngajat = new JButton("Stergere Angajat");
	btnStergereAngajat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//DeleteAngajatView nou = new DeleteAngajatView();
			//nou.main(null);
			frame9.setVisible(true);
		}
	});
	btnStergereAngajat.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnStergereAngajat.setBounds(348, 373, 230, 56);
	frame6.getContentPane().add(btnStergereAngajat);
	
	btnUpdateAngajat = new JButton("Update Angajat");
	btnUpdateAngajat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//EditareAngajatView nou = new EditareAngajatView();
			//nou.main(null);
			frame8.setVisible(true);
		}
	});
	btnUpdateAngajat.setFont(new Font("Tahoma", Font.PLAIN, 17));
	btnUpdateAngajat.setBounds(348, 548, 230, 46);
	frame6.getContentPane().add(btnUpdateAngajat);
	
	//InserareAngajat
	frame7 = new JFrame();
	frame7.setBounds(100, 100, 900, 685);
	frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame7.getContentPane().setLayout(null);
	frame7.setVisible(false);
	
	lblInserareAngajat = new JLabel("Inserare Angajat");
	lblInserareAngajat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	lblInserareAngajat.setBounds(337, 31, 267, 70);
	frame7.getContentPane().add(lblInserareAngajat);
	
	textFieldQ = new JTextField();
	textFieldQ.setBounds(337, 159, 370, 70);
	frame7.getContentPane().add(textFieldQ);
	textFieldQ.setColumns(10);
	
	textField_1Q = new JTextField();
	textField_1Q.setBounds(337, 286, 370, 70);
	frame7.getContentPane().add(textField_1Q);
	textField_1Q.setColumns(10);
	
	textField_2Q = new JTextField();
	textField_2Q.setBounds(337, 414, 370, 65);
	frame7.getContentPane().add(textField_2Q);
	textField_2Q.setColumns(10);
	
	lblNewLabelQ = new JLabel("Nume :");
	lblNewLabelQ.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabelQ.setBounds(136, 158, 135, 75);
	frame7.getContentPane().add(lblNewLabelQ);
	
	lblNewLabel_1Q = new JLabel(" Username :");
	lblNewLabel_1Q.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_1Q.setBounds(136, 283, 135, 70);
	frame7.getContentPane().add(lblNewLabel_1Q);
	
	lblNewLabel_2Q = new JLabel("Parola :");
	lblNewLabel_2Q.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_2Q.setBounds(136, 412, 135, 62);
	frame7.getContentPane().add(lblNewLabel_2Q);
	
	btnNewButtonQ = new JButton("ADAUGARE ");
	btnNewButtonQ.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AngajatConnection angajat = new AngajatConnection();
			Angajat a = new Angajat(textFieldQ.getText(), textField_1Q.getText(), textField_2Q.getText());
			angajat.insert(a);
			JOptionPane.showMessageDialog(btnNewButtonQ, "Angajat adaugat cu succes");
			frame7.dispose();
		}
	});
	btnNewButtonQ.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	btnNewButtonQ.setBounds(337, 550, 195, 75);
	frame7.getContentPane().add(btnNewButtonQ);
	
	//EditareAngajatView
	frame8 = new JFrame();
	frame8.setBounds(100, 100, 900, 685);
	frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame8.getContentPane().setLayout(null);
	frame8.setVisible(false);
	
	lblUpdateEmployee8 = new JLabel("Editare Angajat");
	lblUpdateEmployee8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	lblUpdateEmployee8.setBounds(389, 52, 320, 72);
	frame8.getContentPane().add(lblUpdateEmployee8);
	
	textField8 = new JTextField();
	textField8.setBounds(390, 198, 351, 55);
	frame8.getContentPane().add(textField8);
	textField8.setColumns(10);
	
	textField_28 = new JTextField();
	textField_28.setBounds(390, 316, 351, 55);
	frame8.getContentPane().add(textField_28);
	textField_28.setColumns(10);
	
	lblNewLabel8 = new JLabel("Username :");
	lblNewLabel8.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel8.setBounds(83, 313, 127, 55);
	frame8.getContentPane().add(lblNewLabel8);
	
	textField_38 = new JTextField();
	textField_38.setBounds(390, 424, 351, 55);
	frame8.getContentPane().add(textField_38);
	textField_38.setColumns(10);
	
	lblNewLabel_18 = new JLabel("Parola :");
	lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel_18.setBounds(83, 432, 127, 33);
	frame8.getContentPane().add(lblNewLabel_18);
	
	lblNume8 = new JLabel("Nume :");
	lblNume8.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNume8.setBounds(83, 195, 173, 55);
	frame8.getContentPane().add(lblNume8);
	
	btnNewButton8 = new JButton("EDITARE");
	btnNewButton8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AngajatConnection angajat = new AngajatConnection();
			Angajat a = new Angajat(textField8.getText(), textField_28.getText(), textField_38.getText());
			angajat.update(a);
			JOptionPane.showMessageDialog(btnNewButton8, "Angajat modificat cu succes");
			frame8.dispose();
		}
	});
	btnNewButton8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	btnNewButton8.setBounds(396, 553, 275, 72);
	frame8.getContentPane().add(btnNewButton8);
	
	//StergereAngajat
	frame9 = new JFrame();
	frame9.setBounds(100, 100, 900, 685);
	frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame9.getContentPane().setLayout(null);
	frame9.setVisible(false);
	
	lblNewLabel9 = new JLabel("STERGERE ANGAJAT");
	lblNewLabel9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
	lblNewLabel9.setBounds(284, 32, 361, 88);
	frame9.getContentPane().add(lblNewLabel9);
	
	textField9 = new JTextField();
	textField9.setBounds(366, 311, 403, 55);
	frame9.getContentPane().add(textField9);
	textField9.setColumns(10);
	
	lblNume9 = new JLabel("NUME :");
	lblNume9.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNume9.setBounds(157, 311, 210, 55);
	frame9.getContentPane().add(lblNume9);
	
	btnNewButton9 = new JButton("STERGERE");
	btnNewButton9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AngajatConnection angajat = new AngajatConnection();
			angajat.delete(textField9.getText());
			JOptionPane.showMessageDialog(btnNewButton9, "Angajat sters cu succes");
			frame9.dispose();
		}
	});
	btnNewButton9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	btnNewButton9.setBounds(334, 509, 264, 88);
	frame9.getContentPane().add(btnNewButton9);
	
}
	
	
	
	
	private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) 
	{
		jLabel7.setForeground(Color.BLUE);
	}

	 private void jLabel7MouseExited(java.awt.event.MouseEvent evt) 
	 {
		 jLabel7.setForeground(Color.RED);
	 }
	 
	 private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) 
	 {
		
		loadLanguages("C:/Users/Razvan/Desktop/Simple_Chat/Client2/bin/romana.properties");
		s.attach(this);
		s.notifyAllObservers();
	 }

	 private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) 
	 {
		 jLabel8.setForeground(Color.BLUE);
	 }

	private void jLabel8MouseExited(java.awt.event.MouseEvent evt) 
	{
		 jLabel8.setForeground(Color.RED);
	}
	
	private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) 
	{
		
		loadLanguages("C:/Users/Razvan/Desktop/Simple_Chat/Client2/bin/english.properties");
		s2.attach(this);
		s2.notifyAllObservers();
	}

	private void jLabel9MouseEntered(java.awt.event.MouseEvent evt)
	{
		jLabel9.setForeground(Color.BLUE); 
	}

	private void jLabel9MouseExited(java.awt.event.MouseEvent evt)
	{
		jLabel9.setForeground(Color.RED);
	}

	private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) 
	{
		loadLanguages("C:/Users/Razvan/Desktop/Simple_Chat/Client2/bin/german.properties");
		s3.attach(this);
		s3.notifyAllObservers();
	}

public void loadLanguages(String path)  {
	 
	Properties prop = new Properties();
	try {
		FileInputStream fis = new FileInputStream(path);
		try {
			prop.load(fis);
			
			//VizitatorView
			String vizitator=prop.getProperty("vizitator");
			String sortare=prop.getProperty("sortare");
			String cautare=prop.getProperty("cautare");
			String vizStats=prop.getProperty("vizStats");
			String login=prop.getProperty("login");
			String vizPlante=prop.getProperty("vizPlante");
			//LoginView
			String nume=prop.getProperty("nume");
			String parola=prop.getProperty("parola");
			String conAdmin=prop.getProperty("conAdmin");
			String conAngajat=prop.getProperty("conAngajat");
			//AngajatView
			
			String angajat=prop.getProperty("angajat");
			String insPlanta=prop.getProperty("insPlanta");
			String sterPlanta=prop.getProperty("sterPlanta");
			String updatePlanta=prop.getProperty("updatePlanta");
			String salRaport=prop.getProperty("salRaport");
			//InserarePlanta
			String inserarePlanta=prop.getProperty("inserarePlanta");
			String denumire=prop.getProperty("denumire");
			String tip=prop.getProperty("tip");
			String specie=prop.getProperty("specie");
			String tipCarnivor=prop.getProperty("tipCarnivor");
			String zona=prop.getProperty("zona");
			String adaugare=prop.getProperty("adaugare");
			
			//StergereplantaView
			String stergere=prop.getProperty("stergere");
			
			//UpdatePlantaView
			String actualizare=prop.getProperty("actualizare");
			
			//AdminView
			String admin=prop.getProperty("admin");
			String insAngajat=prop.getProperty("insAngajat");
			String sterAngajat=prop.getProperty("sterAngajat");
			String updateAngajat=prop.getProperty("updateAngajat");
			
			//InserareAngajat
			String user=prop.getProperty("user");
			
			//EditareAngajat
			String editare=prop.getProperty("editare");
			
			
			//VizitatorView
			lblVizitator.setText(vizitator);
			btnVizualizarePlante.setText(vizPlante);
	        btnSortarePlante.setText(sortare);
			btnCautarePlante.setText(cautare);
			btnVizualizareStatistici.setText(vizStats);
			btnLogIn.setText(login);
			//LoginView
			lblLogin.setText(login);
			lblUsername.setText(nume);
			lblPassword.setText(parola);
			btnConnection.setText(conAdmin);
			btnNewButton.setText(conAngajat);
			
			//AngajatView
			lblAngajat.setText(angajat);
			btnInserare.setText(insPlanta);
			btnStergerePlanta.setText(sterPlanta);
			btnUpdatePlanta.setText(updatePlanta); 
			btnSalvareRaport.setText(salRaport);
			
			//InserarePlantaView
			lblInserarePlanta.setText(inserarePlanta);
			lblNewLabel.setText(denumire);		
			lblNewLabel_1.setText(tip);
			lblNewLabel_2.setText(specie);
			lblNewLabel_3.setText(tipCarnivor);
			lblNewLabel_4.setText(zona);
			btnNewButtonI.setText(adaugare);
			
			//StergerePlantaView
			lblNewLabelS.setText(sterPlanta);
			lblNewLabel_1S.setText(denumire);
			btnNewButtonS.setText(stergere);
			
			
			//UpdatePlantaView
			lblNewLabelU.setText(updatePlanta);		
			lblNewLabel_1U.setText(denumire);
			lblNewLabel_2U.setText(tip);
			lblNewLabel_3U.setText(specie);
			lblNewLabel_4U.setText(tipCarnivor);
			lblNewLabel_5U.setText(zona);
			btnNewButtonU.setText(actualizare);
			
			//AdminView
			lblAdmin.setText(angajat);
			btnInserareAngajat.setText(insAngajat);
			btnStergereAngajat.setText(sterAngajat);
			btnUpdateAngajat.setText(updateAngajat);
			
			//InserareAngajat
			lblInserareAngajat.setText(insAngajat);
			lblNewLabelQ.setText(nume);
			lblNewLabel_1Q.setText(user);
			lblNewLabel_2Q.setText(parola);
			btnNewButtonQ.setText(adaugare);
			
			//EditareAngajat
			
			lblUpdateEmployee8.setText(updateAngajat);
			lblNewLabel8.setText(user);
			lblNewLabel_18.setText(parola);
			lblNume8.setText(nume);
			btnNewButton8.setText(updateAngajat);
			
			//StergereAngajatView
			lblNewLabel9.setText(sterAngajat);
			lblNume9.setText(nume);
			btnNewButton9.setText(stergere);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	
	public static void main(String[] args) {
		Interface n = new Interface();
		
	}

	@Override
	public void update() 
	{
		    
			JOptionPane.showMessageDialog(null,"Limba a fost schimbata");		
	}	
}
