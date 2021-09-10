package com.tgid.teste.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotBlank
	private String quantidadeVenda;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String preçoUnidade;
	
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String tempoGarantia;

	@ManyToOne
	@JsonIgnoreProperties("venda")
	private Usuario usuario;

	@ManyToOne
	@JsonIgnoreProperties("venda")
	private Produto produto;

	@ManyToOne
	@JsonIgnoreProperties("venda")
	private ItemVenda itemVenda;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getQuantidadeVenda() {
		return quantidadeVenda;
	}


	public void setQuantidadeVenda(String quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}


	public String getPreçoUnidade() {
		return preçoUnidade;
	}


	public void setPreçoUnidade(String preçoUnidade) {
		this.preçoUnidade = preçoUnidade;
	}


	public String getTempoGarantia() {
		return tempoGarantia;
	}


	public void setTempoGarantia(String tempoGarantia) {
		this.tempoGarantia = tempoGarantia;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public ItemVenda getItemVenda() {
		return itemVenda;
	}


	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}


	
}
