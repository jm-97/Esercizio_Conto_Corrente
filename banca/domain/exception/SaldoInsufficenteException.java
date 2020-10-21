package banca.domain.exception;

import banca.domain.*;

public class SaldoInsufficenteException extends Exception {
  private int id;
  private double saldo; 
  private double amount; 
// Creiamo il costruttore della nostra Eccezione 
public SaldoInsufficenteException ( double saldo, double amount, int id ) {
  /*
    Con il supercostruttore di Exception possiamo assegnare una stringa che ci da il messaggio di errore
    Riferimento javadoc: https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
    Riferimento costruttore: 
   	Exception(String message)
  */
  super("Tentativo di ritiro con fondi non sufficienti sul conto.\n" + "ID Conto: " + id + " Saldo: " + saldo +  "Prelievo   " + amount);
  this.saldo = saldo; 
  this.amount = amount;
  this.id = id; 
}

public double getSaldo () {
  return this.saldo; 
}

public double getAmount () {
  return this.amount; 
}

public double getID () {
  return this.id; 
}
}