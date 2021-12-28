package com.constrular.servicos.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.constrular.servicos.entities.Contato;
import com.constrular.servicos.services.ContatoService;


@RestController
@RequestMapping(value = "/contato")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;

	@GetMapping(value = "/{id}")
	public Optional<Contato> findById(@PathVariable Long id) {
		return contatoService.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Contato saveContato(@Valid @RequestBody Contato contato) {
		return contatoService.save(contato);
	}

	@GetMapping
	public List<Contato> findAll() {
		return contatoService.findAll();
	}
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		contatoService.delete(id);
	}
}
