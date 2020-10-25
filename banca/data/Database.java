package banca.data;

import banca.domain.Cliente;
import banca.domain.Impiegato;

public interface Database {
	public Cliente getClientById(int idCliente);
	public Impiegato getEmployedById ( int idImpiegato );
	public Iterable<Cliente> getAllClients();
	public Iterable<Impiegato> getAllEmployees();
}
