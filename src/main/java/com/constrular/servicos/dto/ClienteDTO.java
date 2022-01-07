package com.constrular.servicos.dto;

import com.constrular.servicos.entities.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
  
	private String nome;
	private String email;
	private String telefone;
	
	
	public Cliente build() {
		
		Cliente cliente = new Cliente()
			.setNome(this.nome)
			.setEmail(this.email)
			.setTelefone(this.telefone);
			
		return cliente;
	}
}
