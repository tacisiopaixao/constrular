package com.constrular.servicos.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.Contato;
import com.constrular.servicos.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id);
	}

	public Contato save(Contato contato) {
		contato.setData(LocalDateTime.now());
		return contatoRepository.save(contato);
	}

	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
}
