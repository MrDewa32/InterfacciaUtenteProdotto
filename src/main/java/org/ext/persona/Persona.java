package org.ext.persona;

import java.util.ArrayList;

public abstract class Persona {

	
	private String nome;
	private String cognome;
	private String mail;
	private String indirizzo;
	
	
	public Persona(String nome, String cognome, String mail, String indirizzo) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.indirizzo = indirizzo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	public String toString() {
	    return "Nome: " + getNome() +
	           "\nCognome: " + getCognome() +
	           "\nEmail: " + getMail() +
	           "\nIndirizzo: " + getIndirizzo();
	}
	
	
}
