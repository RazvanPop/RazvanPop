package Controller;

	import java.awt.GridLayout;
	import java.util.ArrayList;
	import java.util.List;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;

import Model.Planta;
import Model.PlantaConnection;

	public class VizualizarePlante extends JFrame {

		private static final long serialVersionUID = 1L;

		
		public VizualizarePlante()  
		{
			JPanel p1=new JPanel();
			p1.setLayout(new GridLayout(1,1));
			this.add(p1);
			this.setSize(700,400);
			this.setTitle("Vizualiza plante");
			this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setVisible(true);
		    JTable t=createTable();
		    p1.add(t);
		    p1.add(new JScrollPane(t));
		} 
		
		public JTable createTable()
		{
			PlantaConnection planta=new PlantaConnection();
			//PlantaConnection planta=new PlantaConnection();
			List<Planta> lista_plante=planta.viewAll();
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
	}
