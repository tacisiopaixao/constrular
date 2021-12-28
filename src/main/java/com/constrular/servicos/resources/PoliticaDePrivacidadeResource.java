package com.constrular.servicos.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constrular.servicos.entities.PoliticaDePrivacidade;
import com.constrular.servicos.services.PoliticaDePrivacidadeService;


@RestController
@RequestMapping(value = "/politica")
public class PoliticaDePrivacidadeResource {

	@Autowired
	private PoliticaDePrivacidadeService politicaDePrivaciadeService;

	@GetMapping(value = "/{id}")
	public Optional<PoliticaDePrivacidade> findById(@PathVariable Long id) {
		return politicaDePrivaciadeService.findById(id);
	}
}
