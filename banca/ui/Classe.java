package banca.ui;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class Classe implements Iterable<Studente>{
	public List<Studente> listaStudenti=new ArrayList<Studente>();
	public Classe() {
		Studente s1= new Studente(1,"nomeStudente1");
		Studente s2= new Studente(2,"nomeStudente3");
		Studente s3= new Studente(3,"nomeStudente3");
		listaStudenti.add(s3);
		listaStudenti.add(s2);
		listaStudenti.add(s1);
	}

	@Override
	public Iterator<Studente> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Studente> stampaTuttiStudenti(){
		
		for(Studente s:listaStudenti ) {
			System.out.println(s.getId()+s.getNome());
			
		}
		return listaStudenti;
	}
}
