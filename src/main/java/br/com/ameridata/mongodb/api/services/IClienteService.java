package br.com.ameridata.mongodb.api.services;

import java.util.List;

import br.com.ameridata.mongodb.api.documents.Cliente;

public interface IClienteService {

	List<Cliente> listAll();

	Cliente listById(String id);

	Cliente insert(Cliente cliente);

	Cliente update(Cliente cliente);

	void delete(String id);

	void deleteAll();

}
