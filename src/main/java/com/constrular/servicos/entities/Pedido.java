package com.constrular.servicos.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "tb_pedido")
@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pedido")
	private Long codDoPedido;
	private Instant horaDoPedido;
	private Double valorTotal;
	private Integer parcelas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_produto")
	private Produto produto;
}
