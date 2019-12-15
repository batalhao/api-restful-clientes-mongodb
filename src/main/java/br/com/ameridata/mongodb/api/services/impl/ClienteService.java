package br.com.ameridata.mongodb.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ameridata.mongodb.api.documents.Cliente;
import br.com.ameridata.mongodb.api.repositories.ClienteRepository;
import br.com.ameridata.mongodb.api.services.IClienteService;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listById(String id) {
		return this.clienteRepository.findById(id).get();
	}

	@Override
	public Cliente insert(Cliente cliente) {
		return this.clienteRepository.insert(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void delete(String id) {
		this.clienteRepository.deleteById(id);
	}

}
