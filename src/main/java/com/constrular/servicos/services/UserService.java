package com.constrular.servicos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.constrular.servicos.entities.User;
import com.constrular.servicos.repositories.UserRepository;
import com.constrular.servicos.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User save(User user) {
		Optional<User> lista = userRepository.findByUsername(user.getUsername());

		if (lista.isPresent()) {
			return null;
			//Precisa de uma excessão personalizada.
		}
		user.setPassword(criptografarPassword(user.getPassword()));
		return userRepository.save(user);

		//	String senhaNormal = user.getPassword();
		//	String senhacifrada = criptografarPassword(senhaNormal);
		//	user.setPassword(senhacifrada);
	}

	private String criptografarPassword(String password) {
		String passCriptografado = BCrypt.hashpw(password, BCrypt.gensalt());
		return passCriptografado;
	}

	public void delete(Long id) {
		try {
		userRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
