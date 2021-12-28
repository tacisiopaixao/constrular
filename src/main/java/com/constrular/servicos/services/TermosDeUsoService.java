package com.constrular.servicos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.TermosDeUso;
import com.constrular.servicos.repositories.TermosDeUsoRepository;

@Service
public class TermosDeUsoService {

	@Autowired
	private TermosDeUsoRepository termosDeUsoRepository;

	public Optional<TermosDeUso> findById(Long id) {
		
		return termosDeUsoRepository.findById(id);
	}
}
