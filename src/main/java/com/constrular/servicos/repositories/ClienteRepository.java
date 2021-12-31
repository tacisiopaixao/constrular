package com.constrular.servicos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constrular.servicos.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByEmail(String email);
}
