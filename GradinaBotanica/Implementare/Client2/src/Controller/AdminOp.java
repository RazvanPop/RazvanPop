package Controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.Admin;

public class AdminOp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Admin> lista_admini;
	
	public AdminOp()
	{
		lista_admini = new ArrayList<Admin>();
		this.readFilee();
	}
	
	public List<Admin> getAdmini() {
		return lista_admini;
	}
	
	@SuppressWarnings("unchecked")
	public void readFilee()
	{
		try {
	         FileInputStream fileIn = new FileInputStream("Admin.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         lista_admini = (List<Admin>)in.readObject();
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
	         FileOutputStream fileOut = new FileOutputStream("Admin.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(lista_admini);
	         out.close();
	         fileOut.close();
	         System.out.println("Datele au fost serializate");
		}catch(IOException i) {
	         i.printStackTrace();
	    }		
	}
	
	public void addAdmin(Admin a) 
	{
		lista_admini.add(a);
		this.writeFilee();
		System.out.println("Ok");
	}
	
	public void editAdmin(String numeAdmin, String username, String pass) {
		List<Admin> list= new ArrayList<Admin>();
		list = getAdmini();
			for(Admin i:list)
			{
				if(i.getName().equals(numeAdmin))
				{
					i.setUsername(username);
					i.setPass(pass);
				}
			}
		this.writeFilee();
	}
	
	public void deleteAdmin(String numeAdmin) 
	{
		List<Admin> list= new ArrayList<Admin>();
		list = getAdmini();
		
		for( int i = 0; i < list.size(); i++ )
		{
		    Admin lValue = list.get(i);
		    if(lValue.getName().equals(numeAdmin))
		    {
		         list.remove(lValue);
		         i--; 
		    }  
		}
		this.writeFilee();
	}
	
}
