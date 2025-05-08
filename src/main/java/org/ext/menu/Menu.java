package org.ext.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.ext.persona.Utente;
import org.ext.prodotto.Prodotto;

public class Menu {

	public static void menuProdotto(Scanner scan, int menu, Prodotto p) {
		 System.out.println("vista Prodotto!");
			do {
				
				System.out.println("1 - Inserisce i prodotti");
				System.out.println("2 - Stampa tutti i prodotti");
				System.out.println("3 - Stampa la media dei prezzi");
				System.out.println("4 - Torna indietro");
				menu = scan.nextInt();
			
				switch(menu) {
				  case 1:
					  // Inserisce i prodotti
				        p.inserisciProdotti();
				    break;
				  case 2:
					  
					  // Stampa tutti i prodotti
				        p.StampaTuttiProdotti();
					
				    break;
				  case 3:
					  

				        // Stampa la media dei prezzi
				        p.stampaMediaPrezzi();
					  
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
	
	
	
	public static void menuUtente(Scanner scan, ArrayList<Utente> utenti, Utente[] utenteLoggatoRef) {
	    int scelta;
	    do {
	        System.out.println("\n--- MENU UTENTE ---");
	        System.out.println("1 - Mostra utenti di default");
	        System.out.println("2 - Login");
	        System.out.println("3 - Logout");
	        System.out.println("4 - Gestisci carrello");
	        System.out.println("5 - Torna indietro");

	        System.out.print("Scelta: ");
	        scelta = scan.nextInt();

	        switch (scelta) {
	            case 1:
	                System.out.println("UTENTI DI DEFAULT:");
	                for (Utente u : utenti) {
	                    System.out.println("--------------");
	                    System.out.println(u);
	                }
	                break;
	            case 2:
	                if (utenteLoggatoRef[0] == null) {
	                    System.out.print("Inserisci email per il login: ");
	                    String emailInput = scan.next();
	                    boolean trovato = false;
	                    for (Utente u : utenti) {
	                        if (u.verificaLogin(emailInput)) {
	                            utenteLoggatoRef[0] = u;
	                            System.out.println("Login effettuato con successo! Benvenuto, " + u.getNome());
	                            trovato = true;
	                            break;
	                        }
	                    }
	                    if (!trovato) {
	                        System.out.println("Email non trovata. Riprova.");
	                    }
	                } else {
	                    System.out.println("Hai già effettuato il login come " + utenteLoggatoRef[0].getNome());
	                }
	                break;
	            case 3:
	                if (utenteLoggatoRef[0] != null) {
	                    System.out.println("Logout effettuato per " + utenteLoggatoRef[0].getNome());
	                    utenteLoggatoRef[0] = null;
	                } else {
	                    System.out.println("Nessun utente è attualmente loggato.");
	                }
	                break;
	            case 4:
	            	   if (utenteLoggatoRef[0] != null) {
	            	        // Carica i prodotti se non ancora presenti (puoi fare in main una sola volta se preferisci)
	            	        Prodotto prodottiTemporanei = new Prodotto(new HashMap<>());
	            	        prodottiTemporanei.inserisciProdotti();

	            	        Menu.menuCarrello(scan, prodottiTemporanei, utenteLoggatoRef[0]);
	            	    } else {
	            	        System.out.println("Devi effettuare il login prima.");
	            	    }
	                break;
	            case 5:
	                System.out.println("Torno al menu principale...");
	                break;
	            default:
	                System.out.println("Scelta non valida");
	        }

	    } while (scelta != 5);
	}

	public static void menuCarrello(Scanner scan, Prodotto prodotto, Utente utenteLoggato) {
	    int scelta;
	    do {
	        System.out.println("\n--- MENU CARRELLO ---");
	        System.out.println("1 - Aggiungi prodotto al carrello");
	        System.out.println("2 - Visualizza carrello");
	        System.out.println("3 - Rimuovi prodotto dal carrello");
	        System.out.println("4 - Torna indietro");
	        System.out.print("Scelta: ");
	        scelta = scan.nextInt();

	        switch (scelta) {
	            case 1:
	                prodotto.StampaTuttiProdotti();
	                System.out.print("Inserisci il nome esatto del prodotto da aggiungere: ");
	                scan.nextLine(); // pulisce il buffer
	                String nomeProdotto = scan.nextLine();
	                if (prodotto.getProdotto().containsKey(nomeProdotto)) {
	                    utenteLoggato.aggiungiAlCarrello(nomeProdotto);
	                } else {
	                    System.out.println("Prodotto non trovato.");
	                }
	                break;

	            case 2:
	                utenteLoggato.visualizzaCarrello(prodotto.getProdotto());
	                break;

	            case 3:
	            	scan.nextLine(); // pulisce newline da nextInt
	            	HashMap<String, Integer> carrelloAttuale = utenteLoggato.getCarrello();

	            	if (carrelloAttuale.isEmpty()) {
	            	    System.out.println("Il carrello è vuoto.");
	            	} else {
	            	    System.out.println("\n Prodotti nel tuo carrello:");
	            	    for (String prod : carrelloAttuale.keySet()) {
	            	        System.out.println("- " + prod + " x" + carrelloAttuale.get(prod));
	            	    }

	            	    System.out.print("Inserisci il nome del prodotto da rimuovere: ");
	            	    String daRimuovere = scan.nextLine();

	            	    if (carrelloAttuale.containsKey(daRimuovere)) {
	            	        carrelloAttuale.remove(daRimuovere);
	            	        System.out.println("Prodotto rimosso dal carrello.");
	            	    } else {
	            	        System.out.println("Prodotto non trovato nel carrello.");
	            	    }
	            	}

	                break;
	            case 4:
	                System.out.println("Torno al menu utente...");
	                break;
	            default:
	                System.out.println("Scelta non valida.");
	        }
	    } while (scelta != 4);
	}

	
	
}
