package com.tgid.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgid.teste.model.Venda;

@Repository
public interface vendaRepository extends JpaRepository<Venda, Long> {
	public List<Venda> findAllByQuantidadeVendaContainingIgnoreCase(String quantidadeVenda);

}
