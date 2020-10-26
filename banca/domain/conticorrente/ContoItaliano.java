package banca.domain.conticorrente;

// In questa classe Estendiamo la classe ContoCorrente che al momento è classe madre di questa.
public class ContoItaliano extends ContoCorrente {
	
	private static final double TASSA_PERCENTUALE = 5;
	
  // Inizializziamo il costruttore della classe madre dandogli i parametri e passandoli al supercostruttore
  public ContoItaliano( int id, double saldo ) {
    super( id, saldo );
  }

  // Stiamo sovrascrivendo il metodo astratto nella classe ContoCorrente dandogli un funzionamento specifico per ContoItaliano
  @Override
  public void deposita ( double amount ) {
	  double saldofx = getSaldo();
	  
	  	saldofx += (1 - TASSA_PERCENTUALE/100.0) * amount;
	  	
	  	setSaldo(saldofx);
  }
}