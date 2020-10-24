package banca.ui;

public class BankInterface {
	
	public static void main(String[] args) {
		
		BankMenu menu = new BankMenu();
		try {
			menu.stampaMenu();
		}catch(NullPointerException n) {
			System.out.println("Dati Destinatario Errati!");
		}
		
	}
	

}
