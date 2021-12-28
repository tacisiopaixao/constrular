package com.constrular.servicos.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constrular.servicos.entities.TermosDeUso;
import com.constrular.servicos.services.TermosDeUsoService;


@RestController
@RequestMapping(value = "/termos")
public class TermosDeUsoResource {

	@Autowired
	private TermosDeUsoService termosDeUsoService;

	@GetMapping(value = "/{id}")
	public Optional<TermosDeUso> findById(@PathVariable Long id) {
		return termosDeUsoService.findById(id);
	}
}
