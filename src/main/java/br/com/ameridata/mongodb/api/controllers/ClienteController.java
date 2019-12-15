package br.com.ameridata.mongodb.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ameridata.mongodb.api.documents.Cliente;
import br.com.ameridata.mongodb.api.responses.Response;
import br.com.ameridata.mongodb.api.services.impl.ClienteService;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Response<List<Cliente>>> listAll() {
		return ResponseEntity.ok(new Response<List<Cliente>>(this.clienteService.listAll()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Cliente>> listById(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.listById(id)));
	}

	@PostMapping
	public ResponseEntity<Response<Cliente>> insert(@Valid @RequestBody Cliente cliente, BindingResult result) {
		if (result.hasErrors()) { 
			List<String> errosList = new ArrayList<String>();
			result.getAllErrors().forEach(e -> errosList.add(e.getDefaultMessage()));

			return ResponseEntity.badRequest().body(new Response<>(errosList));
		}
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.insert(cliente)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Cliente>> update(@PathVariable(name = "id") String id,
			@Valid @RequestBody Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errosList = new ArrayList<String>();
			result.getAllErrors().forEach(e -> errosList.add(e.getDefaultMessage()));

			return ResponseEntity.badRequest().body(new Response<>(errosList));
		}

		cliente.setId(id);
		return ResponseEntity.ok(new Response<Cliente>(this.clienteService.update(cliente)));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.clienteService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

}