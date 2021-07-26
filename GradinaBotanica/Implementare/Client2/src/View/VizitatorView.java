
package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Controller.CautareDenumirePlanta;
import Controller.HistogramPanel;
import Controller.Observer;
import Controller.Subject;
import Controller.VizualizarePlante;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;


public class VizitatorView extends Observer{

	private JFrame frame;
	private javax.swing.JButton btnVizualizarePlante;
	private javax.swing.JLabel lblVizitator;
	private Subject s = new Subject();
	
	private javax.swing.JButton btnSortarePlante;
	private javax.swing.JButton btnCautarePlante;
	
	private javax.swing.JButton btnVizualizareStatistici;
	private javax.swing.JButton btnLogIn;
	
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizitatorView window = new VizitatorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VizitatorView() {
		initialize();
	}
		
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				LoginView q=new LoginView();
				LoginView.main(null);
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
			loadLanguages("C:/Users/Razvan/Desktop/Simple_Chat/Client1/bin/romanaa.properties");
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
			loadLanguages("C:/Users/Razvan/Desktop/Simple_Chat/Client1/bin/englishh.properties");
		      s.attach(this);
			  s.notifyAllObservers();
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
			loadLanguages("C:/Users/Razvan/Desktop/Simple_Chat/Client1/bin/germann.properties");
		     s.attach(this);
		     s.notifyAllObservers();
		}

	public void loadLanguages(String path)  {
		 
		Properties prop = new Properties();
		try {
		//	FileInputStream fis = new FileInputStream("C:/Users/Razvan/Desktop/Simple_Chat/Client1/bin/englishh.properties");
			FileInputStream fis = new FileInputStream(path);
			System.out.println("Ok");
			try {
				prop.load(fis);
				
				String vizitator=prop.getProperty("vizitator");
				String sortare=prop.getProperty("sortare");
				String cautare=prop.getProperty("cautare");
				String vizStats=prop.getProperty("vizStats");
				String login=prop.getProperty("login");
				String vizPlante=prop.getProperty("vizPlante");
				String nume=prop.getProperty("nume");
				String parola=prop.getProperty("parola");
				String conAdmin=prop.getProperty("conAdmin");
				String conAngajat=prop.getProperty("conAngajat");
			
				//System.out.println(vizitator);
				//System.out.println(sortare);
				//System.out.println(cautare);
				//System.out.println(vizStats);
				//System.out.println(login);
				//System.out.println(vizPlante);
				//System.out.println(nume);
			
				lblVizitator.setText(vizitator);
				btnVizualizarePlante.setText(vizPlante);
		        btnSortarePlante.setText(sortare);
				btnCautarePlante.setText(cautare);
				btnVizualizareStatistici.setText(vizStats);
				//lblPassword.setText(parola);
				//btnConnection.setText(conAdmin);
				btnLogIn.setText(login);
				//LoginView.setLblPassword(parola);
				//System.out.print(LoginView.getLblPassword().getText().toString());
				
				//System.out.println("Ok3");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(prop.getProperty("cautare"));
		
	}


	@Override
	public void update() {
		JOptionPane.showMessageDialog(null,"Limba a fost schimbata");		
	}
		
}
