package banca.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class StatisticheImpiegati {
	private double sommaStipendi; 
	private int numImpiegati; 
	private List<Impiegato> impiegatiMaschiGiovani=new ArrayList<Impiegato>(); 
	private List<Impiegato> listaImpiegati=new ArrayList<Impiegato>();
	private List<Impiegato> uomini = new ArrayList<Impiegato>();
	private List<Impiegato> donne = new ArrayList<Impiegato>();
	
	public List<Impiegato> getImpiegatiMaschiGiovani() {
		return impiegatiMaschiGiovani;
	
	}

	public StatisticheImpiegati combina ( StatisticheImpiegati s1 ) {
		this.sommaStipendi += s1.sommaStipendi; 
		this.numImpiegati += s1.numImpiegati;
		this.impiegatiMaschiGiovani.addAll(s1.getImpiegatiMaschiGiovani());
		this.donne.addAll(s1.getDonne());
		this.uomini.addAll(s1.getUomini());
		this.listaImpiegati.addAll(s1.getListaImpiegati());
		
		return this;
	}
	
	public List<Impiegato> getListaImpiegati() {
		return listaImpiegati;
	}

	public List<Impiegato> getUomini() {
		return uomini;
	}

	public List<Impiegato> getDonne() {
		return donne;
	}

	public StatisticheImpiegati combina ( Impiegato i1 ) {
		this.sommaStipendi += i1.getStipendio(); 
		this.numImpiegati++;
		listaImpiegati.add(i1);
		if(i1.getSesso().equals(Sesso.MASCHIO) && i1.getDataNascita().isAfter(LocalDate.now().minusYears(25))) {
			impiegatiMaschiGiovani.add(i1);
		}
		if(i1.getSesso().equals(Sesso.MASCHIO)) {
			uomini.add(i1);
		}else {
			donne.add(i1);
		}
		
		
		return this; 
	}
	
	public double getStipendioMedio () {
		return this.sommaStipendi / this.numImpiegati; 
	}

	public double getSommaStipendi() {
		return sommaStipendi;
	}

	public double getMediana() {
		if((numImpiegati & 1)==0) {
			listaImpiegati.sort((i1, i2) -> (int) Math.signum(i1.getStipendio() - i2.getStipendio()));
			return (listaImpiegati.get(numImpiegati/2).getStipendio()+listaImpiegati.get(numImpiegati/2-1).getStipendio())/2;
		}
		return listaImpiegati.get(numImpiegati/2).getStipendio();
				
	}
	
	public List<Double> getModa() {
		List<Double> mode=new ArrayList<Double>();
		listaImpiegati.sort((l1,l2)->(int)Math.signum(l1.getStipendio())-(int)Math.signum(l2.getStipendio()));
		Map<Double,Integer> frequenze=new HashMap<Double,Integer>();
		for(Impiegato imp: listaImpiegati) {
			if(frequenze.containsKey(imp.getStipendio())) {
				int temp= frequenze.get(imp.getStipendio()).intValue();
				temp++;
				frequenze.put(imp.getStipendio(), temp);
			}else {
				frequenze.put(imp.getStipendio(), 1);
			}
		}
		
		
		int max=frequenze.values().stream().max((i1,i2)->i1-i2).get();
		if (max ==1) {
			return null;
		}else {
			
			for(Map.Entry<Double, Integer> kv: frequenze.entrySet()) {
				if(kv.getValue()==max) {
					mode.add(kv.getKey());
				}
			}
			return mode;
				
		}	
	}
	
	public boolean confrontoUomoDonna() {
		uomini.sort(((i1, i2) -> (int) Math.signum(i1.getStipendio() - i2.getStipendio())));
		donne.sort(((i1, i2) -> (int) Math.signum(i1.getStipendio() - i2.getStipendio())));
		if(uomini.get(0).getStipendio()<donne.get(donne.size()-1).getStipendio()) {
			return false;
			
		}
		return true;
		
	}
	
}
