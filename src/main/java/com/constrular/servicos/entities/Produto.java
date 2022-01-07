package com.constrular.servicos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "tb_produto")
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_produto")
	private Long codProduto;
	private String nome;
	private String descricao;
	private Double valor;
	private Integer quantidade;
	private String unidadeDeMedida;
	
	@Column(length=512) //aumentando o tamanho da coluna.
	private String imagem;
}
