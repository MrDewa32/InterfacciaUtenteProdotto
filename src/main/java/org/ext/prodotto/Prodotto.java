package org.ext.prodotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prodotto {
		
	private HashMap<String, Double> prodotto;
    private double soglia = 100.0;
	 
	 
	 public Prodotto(HashMap<String, Double> prodotto) {
		this.prodotto = prodotto;
	}
	
	 
	 public void inserisciProdotti(){
		 
		 prodotto.put("Termo refrigeratore Willi Poof", 86.99);
		 prodotto.put("Piloni Miiillle", 999.99);
		 prodotto.put("Frigorifero Tascabile", 44.00);
		 
	 }
	 

	 public void StampaTuttiProdotti(){
				 
		 System.out.println("Tutti i prodotti:");
	     for (HashMap.Entry<String, Double> entry : prodotto.entrySet()) {
	          System.out.println("- " + entry.getKey() + ": €" + entry.getValue());
	      }
				 
	 }
	 public void StampaProdottiSoglia(){
			 
		 
	     List<String> sottoSoglia = new ArrayList<>();

	     for (HashMap.Entry<String, Double> entry : prodotto.entrySet()) {
	          if (entry.getValue() <= soglia) {
	              sottoSoglia.add(entry.getKey());
	          }
	      }
	      System.out.println("\n Prodotti con prezzo ≤ €" + soglia + ":");
	        for (String nome : sottoSoglia) {
	            System.out.println("- " + nome + ": €" + prodotto.get(nome));
	        }
	     
			 
	 }
	 public void stampaMediaPrezzi(){
		 double somma = 0;
	     for (double prezzo : prodotto.values()) {
	          somma += prezzo;
	      }
	      double media = somma / prodotto.size();
	      System.out.printf("\n Prezzo medio: €%.2f\n", media); 
			
			 
	 }
	 
	 //carrello
	 public HashMap<String, Double> getProdotto() {
		    return prodotto;
		}

	 
}
