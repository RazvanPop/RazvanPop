package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Controller.AdminOp;
import Controller.AngajatOp;
import Model.Admin;
import Model.AdminConnection;
import Model.Angajat;
import Model.AngajatConnection;

//import Grd.Admin;
//import Grd.AdminOp;
//import Grd.AdminView;
//import Grd.Angajat;
//import Grd.AngajatOp;
//import Grd.AngajatView;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public  JLabel lblLogin;
	public  JLabel lblUsername;
	public  JLabel lblPassword;
	public  JButton btnConnection;
	public  JButton btnNewButton;


	/*public static JLabel getLblPassword() {
		return lblPassword;
	}

*/
	public void setLblPassword(String name) {
		lblPassword.setText("Georgi");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblLogin = new JLabel("Logare");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblLogin.setBounds(230, 23, 363, 124);
		frame.getContentPane().add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(452, 245, 342, 49);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(452, 352, 342, 49);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblUsername = new JLabel("NUME :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUsername.setBounds(156, 245, 221, 49);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("PAROLA :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPassword.setBounds(156, 352, 221, 49);
		frame.getContentPane().add(lblPassword);
		
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
						System.out.println(i.toString());
						AdminView q=new AdminView();
						AdminView.main(null);
					}
				}
			}
		});
		btnConnection.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConnection.setBounds(92, 475, 235, 89);
		frame.getContentPane().add(btnConnection);
		
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
						AngajatView q=new AngajatView();
						AngajatView.main(null);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(566, 475, 235, 89);
		frame.getContentPane().add(btnNewButton);
	}
	public void loadLanguagesLogin(String path)  {
		 
		Properties prop = new Properties();
		try {
		//	FileInputStream fis = new FileInputStream("C:/Users/Razvan/Desktop/Simple_Chat/Client1/bin/englishh.properties");
			FileInputStream fis = new FileInputStream(path);
			System.out.println("Ok");
			try {
				prop.load(fis);
				
				String login=prop.getProperty("login");
				String nume=prop.getProperty("nume");
				String parola=prop.getProperty("parola");
				//String vizStats=prop.getProperty("vizStats");
				String conAdmin=prop.getProperty("conAdmin");
				String conAngajat=prop.getProperty("conAngajat");
				//String nume=prop.getProperty("nume");
				//String parola=prop.getProperty("parola");
				//String conAdmin=prop.getProperty("conAdmin");
				//String conAngajat=prop.getProperty("conAngajat");
				
					
				System.out.println(login);
				System.out.println(nume);
				System.out.println(parola);
				//System.out.println(vizStats);
				//System.out.println(login);
				//System.out.println(vizPlante);
				//System.out.println(nume);
			
				lblLogin.setText(login);
				lblUsername.setText(nume);
				lblPassword.setText(parola);
				btnConnection.setText(conAdmin);
				btnNewButton.setText(conAngajat);
				//btnLogIn.setText(login);
				//LoginView.setLblPassword(parola);
				//System.out.print(LoginView.getLblPassword().getText().toString());
				
				System.out.println("Ok3");
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
}
