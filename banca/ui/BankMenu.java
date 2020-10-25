package banca.ui;
import java.util.Scanner;

import banca.domain.Banca;
import banca.domain.Cliente;
import banca.domain.ContoCorrente;
//import banca.domain.Cliente;
import banca.domain.exception.SaldoInsufficenteException;

public class BankMenu {
	private Banca b = Banca.getInstance();
	private boolean flag = true;
	private Scanner input= new Scanner(System.in);
	
	public void stampaMenu() {
		
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
				scelta(input.nextInt(), idCliente);
			}
			
		} while (flag);

	}
	
	public void scelta ( int scelta, int idCliente ) {
		switch (scelta) {
			case 1: {
				StringBuilder sb=new StringBuilder("Scegli  il conto dal quale effettuare il bonifico \n")
					.append(b.getClientById(idCliente)).append(System.lineSeparator());
				System.out.println(sb);
				int idConto=input.nextInt();
				while (b.getClientById(idCliente).getContoById(idConto)==null) {
					System.out.println(sb);
					idConto=input.nextInt();
				}
				System.out.println("Inserisci l'id del destinatario , l'id del suo conto e l'importo");
				int idDestinatario=input.nextInt();
				int idContoDestinatario=input.nextInt();
				double amount=input.nextDouble();
				if(b.getClientById(idDestinatario) == null
						&& b.getClientById(idDestinatario).getContoById(idContoDestinatario)== null) {
					throw new NullPointerException();
				}else {
					try {
						b.Bonifica(amount, idConto, idCliente, idContoDestinatario, idDestinatario);
					} catch (SaldoInsufficenteException e){
						System.out.println(e.getMessage());
					}
					
					//System.out.println("Il saldo del destinatario è di : " + b.getClientById(idDestinatario).getContoById(idContoDestinatario).getSaldo());
					System.out.println("Il tuo saldo attuale è: " + b.getClientById(idCliente).getContoById(idConto).getSaldo());
				}	
			} break;
			
			case 2:{
				StringBuilder sb=new StringBuilder("Scegli il conto dal quale prelevare \n")
						.append(b.getClientById(idCliente)).append(System.lineSeparator());
				System.out.println(sb);
				int idConto=input.nextInt();
				System.out.println("Quanto vuoi prelevare?");
				try {
					b.preleva(input.nextDouble(), idCliente, idConto);
				} catch (SaldoInsufficenteException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Il tuo saldo attuale è: "+ b.getClientById(idCliente).getContoById(idConto).getSaldo());
			} break;
			
			case 3:{
				StringBuilder sb=new StringBuilder("Scegli il conto in cui versare \n")
						.append(b.getClientById(idCliente)).append(System.lineSeparator());
				System.out.println(sb);
				int idConto=input.nextInt();
				System.out.println("Quanto vuoi versare?");
				b.Deposita(input.nextDouble(), idConto, idCliente);
				System.out.println("Il tuo saldo attuale è: "+ b.getClientById(idCliente).getContoById(idConto).getSaldo());
			} break;
			
			case 4:{
				System.out.println("I tuoi Saldi:");
				for(ContoCorrente cc : b.getClientById(idCliente).getConti().values()) {
					System.out.println("* Conto numero: "+ cc.getId() + " - Saldo: " + cc.getSaldo());
				}
				System.out.println("Saldo totale: " + b.getClientById(idCliente).getConti().values().stream()
						.mapToDouble(c -> c.getSaldo()).sum());
			} break;
			
			case 5:{
				System.out.println("Lista clienti:");
				for(Cliente cl : b.getClienti()) {
					System.out.println(cl);
				}
			} break;
			
			case 6:{
				System.out.println("Termine programma \nA presto!");
				flag=false;
			} break;
			
			default: System.out.println("Numero non valido!");
		}
		
	}
}
