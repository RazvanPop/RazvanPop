

import java.util.*;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Interfata extends JPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new JFrame("Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 400);
		
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		Polinom pol1=new Polinom();
		Polinom pol2=new Polinom();
		Polinom pol3=new Polinom();
		 
		 
		 JLabel p1 = new JLabel ("coeficientul primului polinom: ");
		 JTextField cf = new JTextField(10);
		 panel1.add(p1);
		 panel1.add(cf);
		 panel1.setLayout(new FlowLayout());
		 
		 JLabel g1 = new JLabel ("gradul primului polinom: ");
		 
		 JTextField gr = new JTextField(10);
		 panel1.add(g1);
		 panel1.add(gr);
		 panel1.setLayout(new FlowLayout());
		 JButton b7 = new JButton("Adaugare");
		 panel1.add(b7);
		 
		
		 JLabel l = new JLabel ("Primul polinom ");
		 JTextField tf = new JTextField(60);
		 panel1.add(l);
		 panel1.add(tf);
		 panel1.setLayout(new FlowLayout());
		
		 
		 JLabel p2 = new JLabel ("coeficientul al doilea polinom: ");
		 JTextField cf2 = new JTextField(10);
		 panel1.add(p2);
		 panel1.add(cf2);
		 panel1.setLayout(new FlowLayout());
		 
		 JLabel g2 = new JLabel ("gradul al doilea polinom: ");
		 JTextField gr2 = new JTextField(10);
		 panel1.add(g2);
		 panel1.add(gr2);
		 panel1.setLayout(new FlowLayout());
		 
		 JButton b8 = new JButton("Adaugare");
		 panel1.add(b8);
		 
		 
		 
		 JLabel j = new JLabel ("Al doilea polinom ");
		 JTextField tf2 = new JTextField(60);
		 panel1.add(j);
		 panel1.add(tf2);
		 panel1.setLayout(new FlowLayout());
		 
		
		 
		 
		 

		 JButton b1 = new JButton("Adunare");
		 JButton b2 = new JButton("Scadere");
		 JButton b3 = new JButton("Inmultire");
		 JButton b4 = new JButton("Impartire");
		 JButton b5 = new JButton("Derivare");
		 JButton b6 = new JButton("Integrale");
		 panel2.add(b1);
		 panel2.add(b2);
		 panel2.add(b3);
		 panel2.add(b4); 
		 panel2.add(b5);
		 panel2.add(b6);
		 
		 
		 
		 JLabel i = new JLabel ("Rezultatul este: ");
		 JTextField tf3 = new JTextField(52);
		 panel1.add(i);
		 panel1.add(tf3);
		 panel1.setLayout(new FlowLayout());

		 JPanel p = new JPanel();
		 p.add(panel1);
		 p.add(panel2);
		 p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		 
		 b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Monom x=new Monom();
				
				x.setCoeficient(Integer.parseInt(cf.getText()));
				x.setGrad(Integer.parseInt(gr.getText()));
				//System.out.println(x);
				pol1.addMon(x);
				//System.out.println(pol1);
				
				tf.setText(tf.getText()+ x.toString());
				
				
				
			}
		 });
		 
		 b8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Monom y=new Monom();
					
					y.setCoeficient(Integer.parseInt(cf2.getText()));
					y.setGrad(Integer.parseInt(gr2.getText()));
					System.out.println(y);
					pol2.addMon(y);
					
					tf2.setText(tf2.getText()+ y.toString());
				}
		 });
		 
		 b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf3.setText(pol1.suma(pol2).toString());
					
				}
		 });
		 
		 b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf3.setText(pol1.diferenta(pol2).toString());
					
				}
		 });
		 
		 b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf3.setText(pol1.inmultire(pol2).toString());
				}
		 });
		 
		 b4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
		 });
		 
		 b5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf3.setText(pol3.Derivare(pol1).toString());
					
				}
		 });
		 
		 b6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tf3.setText(pol3.Integrare(pol1).toString());
				}
		 });
		 
		 cf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
		 });
		
		 System.out.println(pol1);
		 frame.setContentPane(p);
		 frame.setVisible(true); 
		
	}

}
