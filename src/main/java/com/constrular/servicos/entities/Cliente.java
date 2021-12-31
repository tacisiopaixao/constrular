package com.constrular.servicos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(min = 10)
	@NotBlank(message = "No minimo 10 caracteres")
	private String nome;
	
	@Email
	@NotBlank(message = "digite um email válido")
	private String email;
	
	@Length(min = 8)
	@NotBlank(message = "digite um número válido")
	private String telefone; 
	
}
