package banca.domain;

import java.util.List;

public class StatisticheImpiegati {
	private double sommaStipendi; 
	private double mediaStipendi; 
	private double medianaStipendi;
	private int numImpiegati; 
	private List<Impiegato> impiegatiMaschiGiovani; 
	public StatisticheImpiegati combina ( StatisticheImpiegati s1 ) {
		this.sommaStipendi += s1.sommaStipendi; 
		this.numImpiegati += s1.numImpiegati;
		return this;
	}
	
	public StatisticheImpiegati combina ( Impiegato i1 ) {
		this.sommaStipendi += i1.getStipendio(); 
		this.numImpiegati++;
		return this; 
	}
	
	public double getStipendioMedio () {
		return this.sommaStipendi / this.numImpiegati; 
	}
	
	
}
