package com.constrular.servicos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.constrular.servicos.dto.UserRequest;
import com.constrular.servicos.dto.UserResponse;
import com.constrular.servicos.services.AutenticadorService;
import com.constrular.servicos.services.JwtTokenUtil;

@RestController
@RequestMapping(value = "/login")
public class AutenticacaoResource {

	@Autowired
	private AutenticadorService autenticadorService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping
	public UserResponse save(@RequestBody UserRequest userRequest) throws Exception {

		String token = null;

		UserDetails usuario = autenticadorService.loadUserByUsername(userRequest.getEmail());
		
		authenticate(userRequest.getEmail(),userRequest.getSenha());
		
		if (usuario != null) {
			token = jwtTokenUtil.generateToken(usuario);
		}

		UserResponse b = new UserResponse();
		b.setToken(token);

		return b;

	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));		
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("Senha inválida");
		}
	}
}