package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Model.Planta;
import Model.PlantaConnection;

public class PlantaOp implements Serializable{
	
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	private static final String CSV_FILE_NAME = null;
	private List<Planta> lista_plante;
	
	public PlantaOp()
	{
		lista_plante = new ArrayList<Planta>();
		this.readFilee();
	}
	
	public List<Planta> getPlante() {
		return lista_plante;
	}
	
	@SuppressWarnings("unchecked")
	public void readFilee()
	{
		try {
	         FileInputStream fileIn = new FileInputStream("Planta.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         lista_plante = (List<Planta>)in.readObject();
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
	         FileOutputStream fileOut = new FileOutputStream("Planta.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(lista_plante);
	         out.close();
	         fileOut.close();
	        // System.out.println("Datele au fost serializate");
		}catch(IOException i) {
	         i.printStackTrace();
	    }		
	}
	
	public void addPlanta(Planta p) 
	{
		lista_plante.add(p);
		this.writeFilee();
		System.out.println("Ok");
	}
	
	public void editPlanta(String denumirePlanta, String den, String tip, String specie, String carnivor, String zona) {
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
			for(Planta i:list)
			{
				if(i.getDenumire().equals(denumirePlanta))
				{
					i.setDenumire(den);
					i.setTip(tip);
					i.setSpecie(specie);
					i.setCarnivor(carnivor);
					i.setZona(zona);
				}
			}
		this.writeFilee();
	}
	
	public void deletePlanta(String denumirePlanta) 
	{
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
		
		for( int i = 0; i < list.size(); i++ )
		{
		    Planta lValue = list.get(i);
		    if(lValue.getDenumire().equals(denumirePlanta))
		    {
		         list.remove(lValue);
		         i--; 
		    }  
		}
		this.writeFilee();
	}
	
	public List<Planta> cautareDenumire(String denumirePlanta) 
	{
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
		//Planta gasita = new Planta();
		List<Planta> lista_noua=new ArrayList<Planta>();
		for(Planta i:list)
		{
			if(i.getDenumire().equals(denumirePlanta))
			{
				//gasita = i;
				lista_noua.add(i);
			}
		}
		//System.out.println(gasita.toString());
		return lista_noua;
	}
	
	public List<Planta> cautareTip(String tipPlanta) 
	{
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
		//Planta gasita = new Planta();
		List<Planta> lista_noua=new ArrayList<Planta>();
		for(Planta i:list)
		{
			if(i.getTip().equals(tipPlanta))
			{
				//gasita = i;
				lista_noua.add(i);
			}
		}
		//System.out.println(gasita.toString());
		return lista_noua;
	}
	
	public List<Planta> cautareSpecie(String speciePlanta) 
	{
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
		//Planta gasita = new Planta();
		List<Planta> lista_noua=new ArrayList<Planta>();
		for(Planta i:list)
		{
			if(i.getSpecie().equals(speciePlanta))
			{
				//gasita = i;
				lista_noua.add(i);
			}
		}
		//System.out.println(gasita.toString());
		return lista_noua;
	}
	
	public List<Planta> cautareCarnivor(String carnivorPlanta) 
	{
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
		//Planta gasita = new Planta();
		List<Planta> lista_noua=new ArrayList<Planta>();
		for(Planta i:list)
		{
			if(i.getCarnivor().equals(carnivorPlanta))
			{
				//gasita = i;
				lista_noua.add(i);
			}
		}
		//System.out.println(gasita.toString());
		return lista_noua;
	}
	
	public List<Planta> cautareZona(String denumireZona) 
	{
		List<Planta> list= new ArrayList<Planta>();
		list = getPlante();
		//Planta gasita = new Planta();
		List<Planta> lista_noua=new ArrayList<Planta>();
		for(Planta i:list)
		{
			if(i.getZona().equals(denumireZona))
			{
				//gasita = i;
				lista_noua.add(i);
			}
		}
		//System.out.println(gasita.toString());
		return lista_noua;
	}
	*/
	 public void PlanteTxt()
	 {
		 try {
				PrintWriter writer=new PrintWriter("txtPlante.txt");
				PlantaConnection planta_conn =  new PlantaConnection();
				List<Planta> list_planta=planta_conn.viewAll();
	
					for (Planta p:list_planta)
					{
						
							writer.println("Planta:"+p.getDenumire() + " Tip:"+p.getTip()+ " Specie:"+p.getSpecie() + " PlantaCarnivora:"+p.getCarnivor() + "Zona gradina botanica: "+p.getZona() );
					
					}
					writer.close();
					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  
	 }
	 
	 public void PlanteCSV()
	 {
		 try {
				PrintWriter writer=new PrintWriter("csvPlante.csv");
				PlantaConnection planta_conn =  new PlantaConnection();
				List<Planta> list_planta=planta_conn.viewAll();
	
					for (Planta p:list_planta)
					{
						
							writer.println(p.getDenumire() + " ; " +p.getTip()+ " ; " +p.getSpecie()+ " ; " +p.getCarnivor()+ " ; " +p.getZona()+ " ; " );
					
					}
					writer.close();
					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  
	 }
	
	
}
