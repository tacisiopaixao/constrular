package com.constrular.servicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.Cliente;
import com.constrular.servicos.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Optional<Cliente> findById(Long id) {

		return clienteRepository.findById(id);
	}

	public Cliente save(Cliente cliente){
		Optional<Cliente> email = clienteRepository.findByEmail(cliente.getEmail());
		if(email.isEmpty()) {
			
			return clienteRepository.save(cliente);
		}
		
		return null;
		
	}

	public void delete(Long id) {
		clienteRepository.deleteById(id);
		
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

}
