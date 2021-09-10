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

import com.tgid.teste.model.ItemVenda;
import com.tgid.teste.repository.repositoryItemVenda;

@RestController
@RequestMapping("/itemvenda")
@CrossOrigin("*")
public class controllerItemVenda {
	
	@Autowired
	private repositoryItemVenda repository;
	
	@GetMapping
	public ResponseEntity<Object> buscarTudo() {
		List<ItemVenda> listItemVenda = repository.findAll();

		if (listItemVenda.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listItemVenda);
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemVenda> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/espec/{tipoUsuario}")
	public ResponseEntity<List<ItemVenda>> GetByTitulo(@PathVariable String vendedorAtuante) {
		return ResponseEntity.ok(repository.findAllByVendedorAtuanteContainingIgnoreCase(vendedorAtuante));

	}
	
	@PostMapping
	public ResponseEntity<ItemVenda> post(@RequestBody ItemVenda itemVenda) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(itemVenda));

	}
	
	@PutMapping
	public ResponseEntity<ItemVenda> put(@RequestBody ItemVenda itemVenda) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(itemVenda));

	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
