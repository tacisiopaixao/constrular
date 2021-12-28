package com.constrular.servicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constrular.servicos.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
