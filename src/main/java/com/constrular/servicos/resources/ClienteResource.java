package com.constrular.servicos.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.constrular.servicos.entities.Cliente;
import com.constrular.servicos.services.ClienteService;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente saveContato(@Valid @RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	@PutMapping(value = "/{id}")
	public Cliente update(@PathVariable Long id,@RequestBody Cliente obj ){
		Cliente clienteUpdate = clienteService.findById(id).get();
		BeanUtils.copyProperties(obj, clienteUpdate,"id");
		return clienteService.save(clienteUpdate);
		
	}
}
