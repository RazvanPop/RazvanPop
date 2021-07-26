package Model;

import java.io.Serializable;

public class Admin implements Serializable{

	private String name;
	private String username;
	private String pass;
	
	public Admin()
	{}
	
	public Admin(String name, String username, String pass)
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
		return "Admin [name=" + name + ", username=" + username + ", pass=" + pass + "]";
	}
}
