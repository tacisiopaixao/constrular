package com.constrular.servicos.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.constrular.servicos.entities.Pedido;
import com.constrular.servicos.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping(value = "/{id}")
	public Optional<Pedido> findById(@PathVariable Long id) {
		return pedidoService.findById(id);
	}
	
	@GetMapping
	public List<Pedido> findAll() {
		return pedidoService.findAll();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pedido savePedido(@RequestBody Pedido pedido) {
		return pedidoService.save(pedido);
	}
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pedidoService.delete(id);
	}
	@PutMapping(value = "/{id}")
	public Pedido update(@PathVariable Long id,@RequestBody Pedido obj ){
		Pedido pedidoUpdate = pedidoService.findById(id).get();
		BeanUtils.copyProperties(obj, pedidoUpdate,"id");
		return pedidoService.save(pedidoUpdate);
		
	}
}
