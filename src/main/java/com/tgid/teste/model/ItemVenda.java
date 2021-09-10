package com.tgid.teste.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itemVenda")
public class ItemVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	private String precoFrete;
	
	@NotNull
	@NotBlank
	private String filial;
	
	@NotNull
	@NotBlank
	private String vendedorAtuante;
	
	@OneToMany(mappedBy = "itemVenda", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("itemVenda")
	private List<Venda> venda;

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrecoFrete() {
		return precoFrete;
	}

	public void setPrecoFrete(String precoFrete) {
		this.precoFrete = precoFrete;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getVendedorAtuante() {
		return vendedorAtuante;
	}

	public void setVendedorAtuante(String vendedorAtuante) {
		this.vendedorAtuante = vendedorAtuante;
	}
}
