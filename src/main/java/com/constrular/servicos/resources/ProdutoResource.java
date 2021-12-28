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

import com.constrular.servicos.entities.Produto;
import com.constrular.servicos.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/{id}")
	public Optional<Produto> findById(@PathVariable Long id) {
		return produtoService.findById(id);
	}
	
	@GetMapping
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto saveContato(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		produtoService.delete(id);
	}
	@PutMapping(value = "/{id}")
	public Produto update(@PathVariable Long id,@RequestBody Produto obj ){
		Produto produtoUpdate = produtoService.findById(id).get();
		BeanUtils.copyProperties(obj, produtoUpdate,"id");
		return produtoService.save(produtoUpdate);
		
	}
}
