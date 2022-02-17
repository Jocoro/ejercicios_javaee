package com.whiteam.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {
	@JsonProperty("name")
	String nombre;
	@JsonProperty("region")
	String continente;
	String capital;
	@JsonProperty("population")
	long habitantes;
	@JsonProperty("flag")
	String bandera;
	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pais(String nombre, String continente, String capital, long habitantes, String bandera) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.capital = capital;
		this.habitantes = habitantes;
		this.bandera = bandera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}
	public String getBandera() {
		return bandera;
	}
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
	
}
