package banca.ui;

import java.util.Scanner;

import banca.domain.Banca;
import banca.domain.Cliente;
import banca.domain.exception.SaldoInsufficenteException;

public class BankInterface {
	Banca b = Banca.getInstance();
	
	public static void main(String[] args) {
		
		
		
		
		
		
	}
	public void stampaMenu() {
		Scanner input= new Scanner(System.in);
		boolean flag = true;
		
		
		do {
			
			System.out.println("Inserisci il tuo idCliente: ");
			int idCliente=input.nextInt();
			if (b.getClientById(idCliente)!=null) {
				System.out.println("Benvenuto in banca Java. Scegli l'operazione da fare:");
				StringBuilder sb = new StringBuilder();
				sb.append("1 - Bonifico ").append(System.lineSeparator())
				 .append("2 - Prelievo ").append(System.lineSeparator())
				 .append("3 - Versamento ").append(System.lineSeparator())
				 .append("4 - Saldo ").append(System.lineSeparator())
				 .append("5 - Lista utenti").append(System.lineSeparator())
				 .append("6 - Termina il programma").append(System.lineSeparator());
				
				System.out.println(sb);
				scelta(input.nextInt());
			}
			
		}while (flag);
		

	}
	
	public void scelta ( int scelta ) {
		switch (scelta) {
			case 1: {
			
			}break;
		
		}
		
	}

}
