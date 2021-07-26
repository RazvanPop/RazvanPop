package Model;

import java.io.Serializable;

public class Planta implements Serializable{

	private String denumire;
	private String tip;
	private String specie;
	private String carnivor;
	private String zona;
	
	public Planta(String denumire, String tip, String specie, String carnivor, String zona)
	{
		this.denumire = denumire;
		this.tip = tip;
		this.specie = specie;
		this.carnivor = carnivor;
		this.zona = zona;
	}
	
	public Planta()
	{}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getCarnivor() {
		return carnivor;
	}

	public void setCarnivor(String carnivor) {
		this.carnivor = carnivor;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Planta [denumire=" + denumire + ", tip=" + tip + ", specie=" + specie + ", carnivor=" + carnivor
				+ ", zona=" + zona + "]";
	}
	
}
