package banca.domain;

import java.util.ArrayList;
import java.util.List;

import banca.domain.exception.SaldoInsufficenteException;

public class Banca {
			
	//singleton 1 solo oggetto istanziato nella classe
	
	private static Banca instance = new Banca();
	private String nome = "Bank of Java";
	private String[] codiciSegreti = {"adfhfda","asdafaf","zxcxv"};
	
	private List<Cliente> clienti = new ArrayList<Cliente>();
	
	private Banca() {
		init();
	}
	
	private void init() {
		Cliente c1 = new Cliente(1, "ciccio", "pasticcio", 22, Sesso.MASCHIO);
		ContoCorrente cc1 = new ContoCayman(1,100,"asdafaf");
		c1.aggiungiConto(cc1);
		ContoCorrente cc2 = new ContoItaliano(3,300);
		c1.aggiungiConto(cc2);
		clienti.add(c1);
		
		Cliente c2 = new Cliente(2, "paola", "carlito", 24, Sesso.FEMMINA);
		ContoCorrente cc12 = new ContoCayman(15,1000,"asdafar");
		c2.aggiungiConto(cc12);
		ContoCorrente cc22 = new ContoItaliano(36,3000);
		c2.aggiungiConto(cc22);
		clienti.add(c2);	
	}
	
	public Iterable<Cliente> getClienti() {
		return clienti;
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
		for(Cliente cliente : clienti) {
			int id = cliente.getId();
			if(idCliente == id) {
				ContoCorrente x = cliente.getContoById(idConto);
				
				x.deposita(deposito);
				return;
			}
		}
		
	}
	
	public void Bonifica(double bonifico, int idContoSorgente, int idClienteSorgente,
			int idContoDestinatario, int idClienteDestinatario) throws SaldoInsufficenteException {
		
		Cliente sorgente = null;
		Cliente destinatario = null;
		
		for(Cliente c : clienti) {
			int id = c.getId();
			if(idClienteSorgente == id) {
				sorgente=c;
// andrebbe nell'oggetto e modificherebbe sorgente
				//c.setName("Paolo")
			}else if(idClienteDestinatario == id){
				destinatario=c;
			}
		}
		sorgente.getContoById(idContoSorgente)
			.bonifica(bonifico, destinatario.getContoById(idContoDestinatario));		
	}

	
	
	
}
