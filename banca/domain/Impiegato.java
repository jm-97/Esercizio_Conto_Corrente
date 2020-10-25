package banca.domain;

import java.time.LocalDate;

public class Impiegato {
	private int id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private Sesso sesso;
	private double stipendio;
	
	
	
	public Impiegato(int id, String nome, String cognome, LocalDate dataNascita, Sesso sesso, double stipendio) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.stipendio = stipendio;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public Sesso getSesso() {
		return sesso;
	}
	public double getStipendio() {
		return stipendio;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Dati impiegato/a:").append(System.lineSeparator())
		.append("ID: " + this.id).append(System.lineSeparator())
		.append("Nome: " + this.nome).append(System.lineSeparator())
		.append("Cognome: " + this.cognome).append(System.lineSeparator())
		.append("Data di nascita: " + this.dataNascita).append(System.lineSeparator())
		.append("Sesso: " + this.sesso).append(System.lineSeparator())
		.append("Stipendio: " + this.stipendio).append(System.lineSeparator());
		return sb.toString(); 
	}
	
	
}
