package banca.ui.menu;

import java.util.Scanner;

import banca.domain.Banca;

public class BankMenuImpiegati {
	private Banca b = Banca.getInstance();
	private boolean flag = true;
	private Scanner input= new Scanner(System.in);
	
	public void stampaMenu() {
		do {
		StringBuilder sb = new StringBuilder("Scegli l'operazione da effettuare:").append(System.lineSeparator())
		.append("1 - Visualizza somma stipendi").append(System.lineSeparator())
		.append("2 - Visualizza valore medio stipendi").append(System.lineSeparator())
		.append("3 - Visualizza mediana stipendi").append(System.lineSeparator())
		.append("4 - Verifica stipendi uomo / donna").append(System.lineSeparator())
		.append("5 - Stampa impiegati maschi < 25 anni").append(System.lineSeparator())
		.append("6 - Calcolo di tutti i dati").append(System.lineSeparator())
		.append("7 - Stampa impiegati").append(System.lineSeparator())
		.append("8 - Termina programma").append(System.lineSeparator());
		System.out.println(sb.toString());
		scelta(input.nextInt());
		} while ( flag );
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
				System.out.println("Il minor stipendio degli uomini e piu' " + (b.verificaStipendioMaschile() ? "alto" : "basso") + " del maggior stipendio della donne");
			}
			break; 
			case 5: {
				b.getDipendentiMaschiGiovani().forEach(System.out::println);
			}
			break; 
			case 6: {
				StringBuilder sb = new StringBuilder();
				sb.append("La mediana è : "+ b.getAllData().getMediana() +" " ).append(System.lineSeparator());
				
				if(b.getAllData().getModa()==null) {
					sb.append("La moda non esiste").append(System.lineSeparator());
				}else {
					sb.append("Sono state trovate "+b.getAllData().getModa().size()+" mode: ").append(System.lineSeparator());
					for(Double d: b.getAllData().getModa()) {
						
						sb.append(d).append(System.lineSeparator());
					}
					
				}
				sb.append("la somma degli stipendi è: " +b.getAllData().getSommaStipendi()).append(System.lineSeparator());		
				sb.append("lo stipendio medio è : "+b.getAllData().getStipendioMedio()).append(System.lineSeparator());
				sb.append("impiegati maschi minori di 25 anni: ").append(System.lineSeparator());
				b.getAllData().getImpiegatiMaschiGiovani().forEach(y->sb.append(y).append(System.lineSeparator()));
				sb.append("Il minor stipendio degli uomini e piu' " + (b.getAllData().confrontoUomoDonna() ? "alto" : "basso") + "del maggior stipendio della donne");
				
				System.out.println(sb);
			}
			break; 
			case 7: {
				// Method reference con il toString()
				b.getAllEmployees().forEach(System.out::println);
			}
			case 8: {
				System.out.println("Chiusura Programma, arrivederci.");
				flag = false; 
			}
			break;
			default: {
				System.out.println("Scelta sbagliata");
			}
			break; 
		}
	}
}
