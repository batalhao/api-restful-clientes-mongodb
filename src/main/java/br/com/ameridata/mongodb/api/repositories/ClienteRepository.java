package br.com.ameridata.mongodb.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ameridata.mongodb.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
