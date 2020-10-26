package banca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
//import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import banca.data.Database;
import banca.data.FileSystemDatabase;
import banca.data.InMemoryDatabase;
import banca.domain.conticorrente.ContoCorrente;
import banca.domain.exception.SaldoInsufficenteException;

public class Banca  {
			
	//singleton 1 solo oggetto istanziato nella classe
	
	private static Banca instance = new Banca();
	private String nome = "Bank of Java";
	private final static String  FILE_NAME = "impiegati.txt";
	private String[] codiciSegreti = {"adfhfda","asdafaf","zxcxv"};
		
	private Database database = new FileSystemDatabase(FILE_NAME, ",");
	
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
		return ((List<Impiegato>) database.getAllEmployees()).stream().mapToDouble(Impiegato::getStipendio).average().getAsDouble();
	}
	
	public boolean verificaStipendioMaschile () {
		return ((List<Impiegato>) database.getAllEmployees()).stream()
			.filter(i -> i.getSesso().equals(Sesso.MASCHIO))
			.mapToDouble(Impiegato::getStipendio)
			.summaryStatistics().getMin() 
			>
		  	((List<Impiegato>) database.getAllEmployees()).stream()
			.filter(i -> i.getSesso().equals(Sesso.FEMMINA))
			.mapToDouble(Impiegato::getStipendio)
			.summaryStatistics().getMin();
	}
	
	public double getMedianaStipendi () {
		// Non sono sicuro che sia giusto
		List<Impiegato> imps = (List<Impiegato>) database.getAllEmployees();
		if ( (imps.size() & 1) == 0 ) {
		return imps.stream() 
			.sorted((i1, i2) -> (int) Math.signum(i1.getStipendio() - i2.getStipendio()))
			.mapToDouble(Impiegato::getStipendio)
			.limit(imps.size()/2 + 1).skip(imps.size()/2-1).average().getAsDouble();
		} else {
			return imps.stream()
				.sorted((i1, i2) -> (int) Math.signum(i1.getStipendio() - i2.getStipendio()))
				.mapToDouble(Impiegato::getStipendio)
				.skip(imps.size()/2).findFirst().getAsDouble();
		}
	}
	
	public List<Impiegato> getDipendentiMaschiGiovani() {
		return ((List<Impiegato>) database.getAllEmployees()).stream()
		.filter(i -> i.getSesso().equals(Sesso.MASCHIO))
		.filter(i -> i.getDataNascita().isAfter(LocalDate.now().minusYears(25)))
		.collect(Collectors.toList());

	}
	
	public StatisticheImpiegati getAllData () {
		return ((List<Impiegato>) database.getAllEmployees()).strì
		.reduce(new StatisticheImpiegati(), (stat, emp) -> stat.combina(emp), ((u1, u2) -> u1.combina(u2)));
	}
}
