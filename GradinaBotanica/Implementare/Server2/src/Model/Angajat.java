package Model;

import java.io.Serializable;



public class Angajat implements Serializable{

	private String name;
	private String username;
	private String pass;
	
	public Angajat()
	{}
	
	public Angajat(String name, String username, String pass)
	{
		this.name=name;
		this.username=username;
		this.pass=pass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Angajat [name=" + name + ", username=" + username + ", pass=" + pass + "]";
	}
	/*
	@Override
	public void updateP(Object o)
	{
		if (o instanceof PlantaConnection)
		{
			PlantaConnection pc = (PlantaConnection) o;
			System.out.print("Observeeeer");
		}
	}
	*/
}
