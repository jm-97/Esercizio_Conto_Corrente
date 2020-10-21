package banca.domain;

public class ContoCayman extends ContoCorrente {
	
	private String codiceSegreto;

	private static final double BONUS = 10;
	
	public ContoCayman(int id, double saldo, String codiceSegreto) {
		super(id, saldo);
		this.codiceSegreto = codiceSegreto;
	}



	@Override
	public void deposita(double amount) {
		double saldofx = getSaldo(); //read
		
		if(Banca.getInstance().verificaCodice(codiceSegreto)/* == true*/) {
			saldofx += amount*(1+BONUS/100.0); 
		}else {
			saldofx += amount;
		}
		setSaldo(saldofx); //write
	}

}
