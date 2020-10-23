package banca.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banca.domain.Cliente;
import banca.domain.Impiegato;
import banca.domain.Sesso;

public class FileSystemDatabase implements Database {
	private Iterable<Impiegato>impiegati=getAllEmployees();
	
	@Override
	public Cliente getClientById(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Cliente> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Impiegato> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Iterable<Impiegato> getIterableImpiegati(){
		return impiegati;
	}
	
	public Iterable<Impiegato> readFile(String fileName,String separator) {
		List<Impiegato> listaImpiegato=new ArrayList<Impiegato>();
		
		Scanner input=null;
		//String path=new File("").getAbsolutePath();
		//System.out.println(path);
		
		
		
		
		try {
			input = new Scanner(new File(fileName));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (input.hasNextLine()) {
			String line=input.nextLine();
			String[] args=line.split(separator);
			Impiegato imp=new Impiegato(Integer.parseInt(args[0]),args[1],args[2],LocalDate.parse(args[3]),Sesso.valueOf(args[4]),Double.parseDouble(args[5]));                         
			listaImpiegato.add(imp);
			
		}
		return listaImpiegato;
	}

}
