package com.constrular.servicos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.PoliticaDePrivacidade;
import com.constrular.servicos.repositories.PoliticaDePrivacidadeRepository;

@Service
public class PoliticaDePrivacidadeService {

	@Autowired
	private PoliticaDePrivacidadeRepository politicaDePrivacidadeRepository;

	public Optional<PoliticaDePrivacidade> findById(Long id) {
		
		return politicaDePrivacidadeRepository.findById(id);
	}
}
