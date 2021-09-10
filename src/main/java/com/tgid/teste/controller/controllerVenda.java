package com.tgid.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgid.teste.model.Venda;
import com.tgid.teste.repository.vendaRepository;

@RestController
@RequestMapping("/venda")
@CrossOrigin("*")
public class controllerVenda {
  
	@Autowired
	private vendaRepository repository;
	
	@GetMapping
	public ResponseEntity<Object> buscarTudo() {
		List<Venda> listVenda = repository.findAll();

		if (listVenda.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listVenda);
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venda> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/espec/{quantidadeVenda}")
	public ResponseEntity<List<Venda>> GetByTitulo(@PathVariable String quantidadeVenda) {
		return ResponseEntity.ok(repository.findAllByQuantidadeVendaContainingIgnoreCase(quantidadeVenda));

	}

	@PostMapping
	public ResponseEntity<Venda> post(@RequestBody Venda venda) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(venda));

	}
		
	@PutMapping
	public ResponseEntity<Venda> put(@RequestBody Venda venda) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(venda));

	}
		
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
