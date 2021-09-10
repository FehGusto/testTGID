package com.tgid.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgid.teste.model.Produto;

@Repository
public interface produtoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
}
