package banca.domain.conticorrente;

import banca.domain.Cliente;
import banca.domain.exception.*;

public abstract class ContoCorrente {
  // Campi della classe Astratta ContoCorrente
  private int id; 
  private double saldo; 
  private Cliente cliente;
  
  // Costruttore della Classe
  public ContoCorrente ( int id , double saldo ) {
    this.id = id; 
    this.saldo = saldo; 
  } 
  // Acquisisci id 
  public int getId () {
    return this.id; 
  }
  // Acquisisci saldo 
  public double getSaldo () {
    return this.saldo; 
  }
  
  
  public void setSaldo(double saldo) {
	this.saldo = saldo;
}
/*
      Metodi Base del Conto 
  */
  // Metodo astratto deposita
  public abstract void deposita ( double amount );

  // Metodo non astratto preleva
  public void preleva ( double amount ) throws SaldoInsufficenteException {
    if ( amount > this.saldo ) {
      throw new SaldoInsufficenteException(this.saldo, amount, this.id ); 
    }
    this.saldo -= amount; 
  }
  // Metodo per dare un conto ad un cliente
  public void setCliente ( Cliente c ) {
    this.cliente = c;
  }
  
  //Metodo bonifica
  public void bonifica(double amount, ContoCorrente destinatario) throws SaldoInsufficenteException {
	  this.preleva(amount);
	  destinatario.deposita(amount);
  }
  
}