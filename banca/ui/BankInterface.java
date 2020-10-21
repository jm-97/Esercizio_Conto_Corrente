package banca.ui;

import java.util.Scanner;

import banca.domain.Banca;
import banca.domain.Cliente;
import banca.domain.exception.SaldoInsufficenteException;

public class BankInterface {

	public static void main(String[] args) {
			
		Banca b = Banca.getInstance();
		Scanner input= new Scanner(System.in);
		System.out.println("Benvenuto in banca Java. Scegli l'operazione da fare:");
		StringBuilder sb = new StringBuilder();
		sb.append("1 - Bonifico ").append(System.lineSeparator())
		 .append("2 - Prelievo ").append(System.lineSeparator())
		 .append("3 - Versamento ").append(System.lineSeparator())
		 .append("4 - Saldo ").append(System.lineSeparator())
		 .append("5 - Lista utenti").append(System.lineSeparator());
		
		System.out.println(sb);
		/*
		Iterable<Cliente> ic = b.getClienti();
		
		for(Cliente c : ic) {
			System.out.println(c);
		}
		
		b.Deposita(100, 1, 1);
		
		for(Cliente c : ic) {
			System.out.println(c);
		}
		
		try {
			b.Bonifica(1000, 36, 2, 3, 1);
		} catch (SaldoInsufficenteException e) {
			System.out.println(e.getMessage());
		}
		
		for(Cliente c : ic) {
			System.out.println(c);
		}
		*/
		
		
	}

}
