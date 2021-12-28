package com.constrular.servicos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.constrular.servicos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String email);

}
