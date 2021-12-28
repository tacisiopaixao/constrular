package com.constrular.servicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constrular.servicos.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
