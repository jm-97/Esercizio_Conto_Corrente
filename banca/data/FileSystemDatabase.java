package banca.data;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import banca.domain.Cliente;
import banca.domain.Impiegato;
import banca.domain.Sesso;

public class FileSystemDatabase implements Database {
	
	private List<Impiegato>impiegati;
	private String separator;
	private String nomefile;
	
	public FileSystemDatabase(String nomefile, String separator) {
		this.separator = separator;
		this.nomefile = nomefile;
		this.impiegati = readFile();
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getNomefile() {
		return nomefile;
	}

	public void setNomefile(String nomefile) {
		this.nomefile = nomefile;
	}

	@Override
	public Cliente getClientById(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Cliente> getAllClients() {
		return null;
	}

	@Override
	public List<Impiegato> getAllEmployees() {
		return this.impiegati;
	}
	
	
	public List<Impiegato> readFile() {
		List<Impiegato> listaImpiegato=new ArrayList<Impiegato>();
		Scanner input=null;
		try {
			input = new Scanner(new File(this.nomefile));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (input.hasNextLine()) {
			String line = input.nextLine();
			String[] args= line.split(this.separator);
			Impiegato imp = new Impiegato(Integer.parseInt(args[0].trim()),args[1].trim(),args[2].trim(), LocalDate.parse(args[3].trim()),Sesso.valueOf(args[4].trim()),Double.parseDouble(args[5].trim()));                         
			listaImpiegato.add(imp);
		}
		return listaImpiegato;
	}

	@Override
	public Impiegato getEmployedById(int idImpiegato) {
		for ( Impiegato i : impiegati ) {
			if ( i.getId() == idImpiegato ) {
				return i;
			}
		}
		return null;
	}

}
