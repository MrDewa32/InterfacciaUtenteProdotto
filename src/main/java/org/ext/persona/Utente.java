package org.ext.persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utente extends Persona {

	private static int id_utente;
	private  ArrayList<Integer> ordiniProdotti;
	private HashMap<String, Integer> carrello = new HashMap<>();
	

	
	
	public Utente(String nome, String cognome, String mail, String indirizzo,int id_utente, ArrayList<Integer> ordiniProdotti) {
		super(nome, cognome, mail, indirizzo);
		this.id_utente = id_utente++;
		
		//this.ordiniProdotti = new ArrayList<>(ordiniProdotti); 
		this.ordiniProdotti = (ordiniProdotti != null) ? new ArrayList<>(ordiniProdotti) : new ArrayList<>();
		
	}





	public static int getId_utente() {
		return id_utente;
	}





	public static void setId_utente(int id_utente) {
		Utente.id_utente = id_utente;
	}





	public ArrayList<Integer> getOrdiniProdotti() {
		return ordiniProdotti;
	}



	public void setOrdiniProdotti(ArrayList<Integer> ordiniProdotti) {
		this.ordiniProdotti = ordiniProdotti;
	}
	
	public HashMap<String, Integer> getCarrello() {
	    return carrello;
	}

	
		
	
	
	public static ArrayList<Utente> creaUtentiDefault() {
	    ArrayList<Utente> utenti = new ArrayList<>();
	    utenti.add(new Utente("Mario", "Rossi", "mario@email.com", "Via Roma 1", id_utente, null));
	    utenti.add(new Utente("Laura", "Bianchi", "laura@email.com", "Via Milano 5", id_utente, null));
	    utenti.add(new Utente("Giulia", "Verdi", "giulia@email.com", "Via Torino 12", id_utente, null));
	    return utenti;
	}

	@Override
	public String toString() {
	    return super.toString() +
	           "\nID Utente: " + id_utente +
	           "\nOrdini: " + ordiniProdotti;
	}
	
	public boolean verificaLogin(String mailInput) {
	    return this.getMail().equalsIgnoreCase(mailInput);
	}
	
	
//carrello
	
	public void aggiungiAlCarrello(String nomeProdotto) {
	    carrello.put(nomeProdotto, carrello.getOrDefault(nomeProdotto, 0) + 1);
	    System.out.println(nomeProdotto + " aggiunto al carrello.");
	}

	public void visualizzaCarrello(HashMap<String, Double> prodottiDisponibili) {
	    if (carrello.isEmpty()) {
	        System.out.println("Il carrello è vuoto.");
	        return;
	    }

	    System.out.println("Contenuto del carrello:");
	    double totale = 0.0;

	    for (Map.Entry<String, Integer> entry : carrello.entrySet()) {
	        String prodotto = entry.getKey();
	        int quantita = entry.getValue();
	        double prezzo = prodottiDisponibili.getOrDefault(prodotto, 0.0);
	        double subtotale = prezzo * quantita;
	        totale += subtotale;
	        System.out.printf("- %s x%d: €%.2f\n", prodotto, quantita, subtotale);
	    }

	    System.out.printf("Totale: €%.2f\n", totale);
	}


}
