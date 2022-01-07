package com.constrular.servicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constrular.servicos.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
