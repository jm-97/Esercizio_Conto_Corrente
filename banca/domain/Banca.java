package banca.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import banca.data.Database;
import banca.data.FileSystemDatabase;
import banca.data.InMemoryDatabase;
import banca.domain.exception.SaldoInsufficenteException;

public class Banca  {
			
	//singleton 1 solo oggetto istanziato nella classe
	
	private static Banca instance = new Banca();
	private String nome = "Bank of Java";
	private String[] codiciSegreti = {"adfhfda","asdafaf","zxcxv"};
		
	private Database database = new InMemoryDatabase();
	private Database dbImpiegati = new FileSystemDatabase();
	private Banca() {
	}
	
	
	public Iterable<Cliente> getClienti() {
		return database.getAllClients();
	}

	public static Banca getInstance() {
		return instance;
	}
	
	public boolean verificaCodice(String codiceSegreto) {
		
		for(String codice : codiciSegreti) {
			if (codiceSegreto.equals(codice)) {
				return true;
			}
		}
	return false;
	}
	
	public void Deposita(double deposito, int idConto, int idCliente) {
		Cliente c=database.getClientById(idCliente);
		c.getContoById(idConto).deposita(deposito);
		
	}
	
	public void Bonifica(double bonifico, int idContoSorgente, int idClienteSorgente,
			int idContoDestinatario, int idClienteDestinatario) throws SaldoInsufficenteException {
		
		Cliente sorgente = database.getClientById(idClienteSorgente);
		Cliente destinatario = database.getClientById(idClienteDestinatario);
		ContoCorrente ccsorgente=sorgente.getContoById(idContoSorgente);
		ContoCorrente ccdestinatario=destinatario.getContoById(idContoDestinatario);
		
		/*sorgente.getContoById(idContoSorgente)
			.bonifica(bonifico, destinatario.getContoById(idContoDestinatario));*/		
		ccsorgente.bonifica(bonifico, ccdestinatario);
		
	}
	
	public void preleva(double amount,int idCliente, int idConto) throws SaldoInsufficenteException {
		Cliente c=database.getClientById(idCliente);
		c.getContoById(idConto).preleva(amount);
		
	}

	public Cliente getClientById(int idCliente) {
		
		return database.getClientById(idCliente);
	}
	
	public double getSommaStipendi() {
		Collection<Impiegato> ci=(Collection)dbImpiegati.getAllEmployees();
		return null;//to do da fare
	}
	
}
