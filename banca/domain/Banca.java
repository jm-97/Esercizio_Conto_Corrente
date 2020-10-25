package banca.domain;

import java.util.Collections;
import java.util.Comparator;
//import java.util.ArrayList;
//import java.util.Collection;
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
		
	private Database database = new FileSystemDatabase("impiegati.txt", ",");
	
	public Iterable<Cliente> getClienti() {
		return database.getAllClients();
	}
	
	private Banca() {
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
		ccsorgente.bonifica(bonifico, ccdestinatario);
		
	}
	
	public void preleva(double amount,int idCliente, int idConto) throws SaldoInsufficenteException {
		Cliente c=database.getClientById(idCliente);
		c.getContoById(idConto).preleva(amount);
		
	}

	public Cliente getClientById(int idCliente) {
		
		return database.getClientById(idCliente);
	}
	
	public Iterable<Impiegato> getAllEmployees() {
		return database.getAllEmployees();
	}
	
	
	public double getSommaStipendi() {
		return ((List<Impiegato>) database.getAllEmployees()).stream().mapToDouble(Impiegato::getStipendio).sum();
	}
	
	public double getMediaStipendi() {
		List<Impiegato> imps = (List<Impiegato>) database.getAllEmployees();
		return ( getSommaStipendi() / imps.size() );
		// Utilizzato lo stream del somma stipendi
	}
	
	public boolean verificaStipendioMaschile () {
		return false; // Ancora da implementare
	}
	
	public double getMedianaStipendi () {
		// Non sono sicuro che sia giusto
		List<Impiegato> imps = (List<Impiegato>) database.getAllEmployees();
		imps.sort((i1, i2) -> (int) Math.signum(i1.getStipendio() - i2.getStipendio())); 
		return imps.get(imps.size() / 2).getStipendio();
	}
	
	
}
