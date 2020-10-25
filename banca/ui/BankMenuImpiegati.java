package banca.ui;

import java.util.Scanner;

import banca.domain.Banca;

public class BankMenuImpiegati {
	private Banca b = Banca.getInstance();
	private Scanner input= new Scanner(System.in);
	
	public void stampaMenu() {
		StringBuilder sb = new StringBuilder("Scegli l'operazione da effettuare:").append(System.lineSeparator())
		.append("1 - Visualizza somma stipendi").append(System.lineSeparator())
		.append("2 - Visualizza valore medio stipendi").append(System.lineSeparator())
		.append("3 - Visualizza mediana stipendi").append(System.lineSeparator())
		.append("4 - Verifica stipendi uomo / donna").append(System.lineSeparator())
		.append("5 - Stampa impiegati maschi < 25 anni").append(System.lineSeparator())
		.append("6 - Calcolo di tutti i dati").append(System.lineSeparator());
		System.out.println(sb.toString());
		scelta(input.nextInt());
	}
	
	public void scelta ( int idScelta ) {
		switch ( idScelta ) {
			case 1: {
				System.out.println("La somma stipendi degli impiegati e di: " + b.getSommaStipendi());
			}
			break;
			case 2: {
				System.out.println("Il valore medio degli stipendi è di: " + b.getMediaStipendi());
			}
			break; 
			case 3: {
				System.out.println("La mediana è di: " + b.getMedianaStipendi());
			}
			break; 
			case 4: {
				
			}
			break; 
			case 5: {
				
			}
			break; 
			case 6: {
				
			}
			break; 
			}
		}
}
