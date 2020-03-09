
import java.awt.FlowLayout;
import java.util.* ;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends Thread{
	
		public static JTextField tf = new JTextField(40);
		public static JTextField tf2 = new JTextField(40);
		public static JTextField tf3 = new JTextField(40);
		public static JTextField tf4 = new JTextField(40);

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			
				 JFrame frame = new JFrame ("Simple Frame");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.setSize(700, 400);

				 JPanel panel1 = new JPanel();
				 JPanel panel2 = new JPanel();

				 JLabel l = new JLabel ("Prima coada de magazin");
				 
				 panel1.add(l);
				 panel1.add(tf);
				 panel1.setLayout(new FlowLayout());
				 
				 JLabel l2 = new JLabel ("A doua coada de magazin");
				 
				 panel1.add(l2);
				 panel1.add(tf2);
				 panel1.setLayout(new FlowLayout());
				 
				 JLabel l3 = new JLabel ("A treia coada de magazin");
				 
				 panel1.add(l3);
				 panel1.add(tf3);
				 panel1.setLayout(new FlowLayout());
				 
				 JLabel l4 = new JLabel ("A patra coada de magazin");
				 
				 panel1.add(l4);
				 panel1.add(tf4);
				 panel1.setLayout(new FlowLayout());
				 
				 
				 

				

				 JPanel p = new JPanel();
				 p.add(panel1);
				 p.add(panel2);
				 p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

				 frame.setContentPane(p);
				 frame.setVisible(true);
				 
				 Coada c=new Coada();
				 Coada a=new Coada();
				 Coada b=new Coada();
				 Coada d=new Coada();
					new Magazin(c,a,b,d);
					
					
				
					
					
			
					
				
				//	new Magazin(a);
					
					
					
					
					
					
			
				//	new Magazin(b);
					
					
					
					
					
					
					
				//	new Magazin(d);
					
					
					
					
				   
					new Persoane(c,a,b,d);
					
					
			//		new Persoane(a);
					
			//		new Persoane(b);
					
			//		new Persoane(d);
				 }
			
			
			
			
			
	}





