package com.tgid.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgid.teste.model.ItemVenda;

@Repository
public interface repositoryItemVenda extends JpaRepository<ItemVenda, Long>{
	public List<ItemVenda> findAllByVendedorAtuanteContainingIgnoreCase(String vendedorAtuante);
}
