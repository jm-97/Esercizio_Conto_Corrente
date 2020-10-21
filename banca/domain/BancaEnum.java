package banca.domain;

public enum BancaEnum {
	
	BANK_OF_JAVA("LA miglior banca per i programmatori Java");
	
	private String nome;
	
	private BancaEnum(String s) {
		this.nome=s;
	}

}
