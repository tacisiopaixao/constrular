package com.constrular.servicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.Produto;
import com.constrular.servicos.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Optional<Produto> findById(Long id){
		
		return produtoRepository.findById(id);
	}

	public List<Produto> findAll() {
		
		return produtoRepository.findAll();
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void delete(Long id) {
		produtoRepository.deleteById(id);
		
	}

}
