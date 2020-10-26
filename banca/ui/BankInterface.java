package banca.ui;

import java.util.Scanner;

import banca.ui.menu.BankMenu;
import banca.ui.menu.BankMenuImpiegati;

public class BankInterface {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BankMenu menuClienti = new BankMenu();
		BankMenuImpiegati menuImpiegati = new BankMenuImpiegati();
		System.out.println("Benvenuto in banca Java.\n" + "Digita 1 per accedere alle operazioni per i clienti.\n" + "Digita 2 per accedere alle operazioni per gli impiegati");
		int idScelta = input.nextInt();
		if ( idScelta == 1 ) {
			menuClienti.stampaMenu();
		} else if ( idScelta == 2 ) {
			menuImpiegati.stampaMenu();
		} else {
			System.out.println("Scelta errata.");
		}
	}
	

}
