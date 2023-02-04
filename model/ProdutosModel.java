package com.generation.projetofarmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class ProdutosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 144)
	private String nome;
	
	@NotBlank
	private String quantidade;
	
	
	//@Size(max = 144)
	 BigDecimal preço;
	 
	 @ManyToOne
	 @JsonIgnoreProperties("nome")
	 private AtributosModel atributo;

	public AtributosModel getAtributo() {
		return atributo;
	}

	public void setAtributo(AtributosModel atributo) {
		this.atributo = atributo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreço() {
		return preço;
	}

	public void setPreço(BigDecimal preço) {
		this.preço = preço;
	}
	
	
	
}