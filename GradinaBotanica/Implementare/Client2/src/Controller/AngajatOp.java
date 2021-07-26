package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Angajat;

public class AngajatOp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Angajat> lista_angajati;
	
	public AngajatOp()
	{
		lista_angajati = new ArrayList<Angajat>();
		this.readFilee();
	}
	
	public List<Angajat> getAngajati() {
		return lista_angajati;
	}
	
	@SuppressWarnings("unchecked")
	public void readFilee()
	{
		try {
	         FileInputStream fileIn = new FileInputStream("Angajat1.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         lista_angajati = (List<Angajat>)in.readObject();
	         in.close();
	         fileIn.close();
	         System.out.println("Datele au fost citite");
		}catch(IOException i) {
			i.printStackTrace();
		}catch(ClassNotFoundException c) {
			c.printStackTrace();
		}	
	}
	
	public void writeFilee() 
	{
		try {
	         FileOutputStream fileOut = new FileOutputStream("Angajat1.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(lista_angajati);
	         out.close();
	         fileOut.close();
	         System.out.println("Datele au fost serializate");
		}catch(IOException i) {
	         i.printStackTrace();
	    }		
	}
	
	public void addAngajat(Angajat a) 
	{
		lista_angajati.add(a);
		this.writeFilee();
		System.out.println("Ok");
	}
	
	public void editAngajat(String numeAngajat, String username, String pass) {
		List<Angajat> list= new ArrayList<Angajat>();
		list = getAngajati();
			for(Angajat i:list)
			{
				if(i.getName().equals(numeAngajat))
				{
					i.setUsername(username);
					i.setPass(pass);
				}
			}
		this.writeFilee();
	}
	
	public void deleteAngajat(String numeAngajat) 
	{
		List<Angajat> list= new ArrayList<Angajat>();
		list = getAngajati();
		
		for( int i = 0; i < list.size(); i++ )
		{
		    Angajat lValue = list.get(i);
		    if(lValue.getName().equals(numeAngajat))
		    {
		         list.remove(lValue);
		         i--; 
		    }  
		}
		this.writeFilee();
	}
	
}
