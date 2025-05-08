package org.ext.main;
import org.ext.persona.Utente;
import org.ext.prodotto.Prodotto;
import org.ext.menu.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	
		
		Prodotto p = new Prodotto(new HashMap<>());  
		Utente[] utenteLoggato = new Utente[1]; // serve per tenere traccia dell’utente loggato(mi raccomando)
		ArrayList<Utente> utenti = Utente.creaUtentiDefault();

		Scanner scan = new Scanner(System.in);
		int menu;
		System.out.println("Benvenuto!");
		do {
			
			System.out.println("1 - vista Prodotto");
			System.out.println("2 - vista utente!");
			System.out.println("3 - ");
			System.out.println("4 - Esci");
			menu = scan.nextInt();

			switch(menu) {
			  case 1:
				 
				  Menu.menuProdotto(scan, menu, p);
					
			    break;
			  case 2:
				  Menu.menuUtente(scan, utenti, utenteLoggato);
			    break;
			  case 3:
				
				  

			    
				  
				  
				break;
			  case 4:
				  System.out.println("Grazie e arrivederci");
				break;
			    
			  default:
				  System.out.println("Scelta non valida");
			}
			}
			while (menu != 4);
		

	    

		
	}

}
