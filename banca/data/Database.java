package banca.data;

import banca.domain.Cliente;

public interface Database {
	public Cliente getClientById(int idCliente);
	public Iterable<Cliente> getAllClients();
}
