package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import Controller.PlantaOp;
import Model.Planta;
import Model.PlantaConnection;

import javax.swing.JButton;

public class FiltarePlanteView extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltarePlanteView window = new FiltarePlanteView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTable createTableTip()
	{
		PlantaConnection planta=new PlantaConnection();
		List<Planta> lista_plante=(List<Planta>) planta.findByTip(textField.getText());
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
	
	public JTable createTableSpecie()
	{
		PlantaConnection planta=new PlantaConnection();
		List<Planta> lista_plante=planta.findBySpecie(textField_1.getText());
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
	
	
	public JTable createTableCarnivor()
	{
		PlantaConnection planta=new PlantaConnection();
		List<Planta> lista_plante=planta.findByCarnivor(textField_2.getText());
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
	
	public JTable createTableZona()
	{
		PlantaConnection planta=new PlantaConnection();
		List<Planta> lista_plante=planta.findByZona(textField_3.getText());
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
	
	/**
	 * Create the application.
	 */
	public FiltarePlanteView() {
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
		
		JLabel lblFiltrare = new JLabel("Filtrare");
		lblFiltrare.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblFiltrare.setBounds(408, 35, 238, 42);
		frame.getContentPane().add(lblFiltrare);
		
		JLabel lblNewLabel = new JLabel("Tip");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(87, 157, 105, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Specie");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(87, 268, 105, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Planta Carnivora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(87, 390, 177, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Zona");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(87, 513, 154, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(318, 158, 268, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(318, 269, 268, 36);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(318, 393, 268, 33);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(318, 513, 268, 33);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		final JButton btnNewButton = new JButton("Cautare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel p1=new JPanel();
				p1.setLayout(new GridLayout(1,1));
				add(p1);
				setSize(700,400);
				setTitle("Cautare tip");
				setLocationRelativeTo(null);
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setVisible(true);
			    JTable t=createTableTip();
			    p1.add(t);
			    p1.add(new JScrollPane(t));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(720, 157, 109, 33);
		frame.getContentPane().add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Cautare");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel p2=new JPanel();
				p2.setLayout(new GridLayout(1,1));
				add(p2);
				setSize(700,400);
				setTitle("Cautare specie");
				setLocationRelativeTo(null);
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setVisible(true);
			    JTable t=createTableSpecie();
			    p2.add(t);
			    p2.add(new JScrollPane(t));
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(720, 268, 109, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("Cautare");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel p3=new JPanel();
				p3.setLayout(new GridLayout(1,1));
				add(p3);
				setSize(700,400);
				setTitle("Cautare planta carnivora");
				setLocationRelativeTo(null);
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setVisible(true);
			    JTable t=createTableCarnivor();
			    p3.add(t);
			    p3.add(new JScrollPane(t));
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(720, 390, 109, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		final JButton btnNewButton_3 = new JButton("Cautare");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel p3=new JPanel();
				p3.setLayout(new GridLayout(1,1));
				add(p3);
				setSize(700,400);
				setTitle("Cautare zona");
				setLocationRelativeTo(null);
			    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    setVisible(true);
			    JTable t=createTableZona();
			    p3.add(t);
			    p3.add(new JScrollPane(t));
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(720, 513, 109, 32);
		frame.getContentPane().add(btnNewButton_3);
	}

}
