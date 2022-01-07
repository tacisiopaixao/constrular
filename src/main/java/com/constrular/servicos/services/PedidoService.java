package com.constrular.servicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.Pedido;
import com.constrular.servicos.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Optional<Pedido> findById(Long id) {

		return pedidoRepository.findById(id);
	}

	public List<Pedido> findAll() {

		return pedidoRepository.findAll();
	}

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void delete(Long id) {
		pedidoRepository.deleteById(id);

	}

}
