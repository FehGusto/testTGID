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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "produto")
public class Produto {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String nomeProduto;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 1000)
	private String estoqueProduto;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String categoriaProduto;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("produto")
	private List<Venda> venda;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	
	public String getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(String estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public List<Venda> getVenda() {
		return venda;
	}

	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}
	
}
