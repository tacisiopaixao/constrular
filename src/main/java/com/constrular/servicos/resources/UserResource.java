package com.constrular.servicos.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.constrular.servicos.entities.User;
import com.constrular.servicos.services.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return Optional.of(userService.findById(id));
	}
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User saveContato(@Valid @RequestBody User user) {
		return userService.save(user);
	}
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
	@PutMapping(value = "/{id}")
	public User update(@PathVariable Long id,@RequestBody User obj ){
		User userUpdate = userService.findById(id);
		BeanUtils.copyProperties(obj, userUpdate,"id");
		return userService.save(userUpdate);
		
	}
}
