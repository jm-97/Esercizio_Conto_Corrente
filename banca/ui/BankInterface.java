package banca.ui;

import java.util.Scanner;

import banca.data.FileSystemDatabase;
import banca.domain.Banca;
import banca.domain.Cliente;
import banca.domain.exception.SaldoInsufficenteException;

public class BankInterface {
	
	public static void main(String[] args) {
		
		BankMenu menu = new BankMenu();
		try {
			menu.stampaMenu();
		} catch (SaldoInsufficenteException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		
	}
	

}
