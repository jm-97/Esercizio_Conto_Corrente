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
	
	
}
