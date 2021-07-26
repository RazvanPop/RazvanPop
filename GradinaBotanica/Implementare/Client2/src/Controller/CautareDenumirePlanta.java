package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.Planta;
import Model.PlantaConnection;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CautareDenumirePlanta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CautareDenumirePlanta window = new CautareDenumirePlanta();
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
	
	public JTable createTable()
	{
		PlantaConnection planta=new PlantaConnection();
		List<Planta> lista_plante=planta.findByDenumire(textField.getText());
		Object row[][]=new Object[lista_plante.size()][5];
		Object col[]= {"Denumire","Tip","Specie","Planta carnivora", "Zona"};

		int i=0;
	
		for (Planta c:lista_plante)
		{					   
			row[i][0]=c.getDenumire();
			row[i][1]=c.getTip();
			row[i][2]=c.getSpecie();
			row[i][3]=c.getCarnivor();
			row[i][4]=c.getZona();
			i++;
			c.toString();
	    }
		
		JTable plantTable=new JTable(row,col);
		return plantTable;
	}
	
	public CautareDenumirePlanta() {
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
		
		JLabel lblNewLabel = new JLabel("Cautare denumire");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(322, 44, 313, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Denumire :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(118, 225, 195, 88);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(402, 244, 390, 57);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JButton btnNewButton = new JButton("Cautare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel p1=new JPanel();
				p1.setLayout(new GridLayout(1,1));
				add(p1);
				setSize(700,400);
				setTitle("Cautare denumire");
				setLocationRelativeTo(null);
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setVisible(true);
			    JTable t=createTable();
			    p1.add(t);
			    p1.add(new JScrollPane(t));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBounds(322, 427, 292, 88);
		frame.getContentPane().add(btnNewButton);
	}

}
