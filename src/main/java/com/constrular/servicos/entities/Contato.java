package com.constrular.servicos.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Não permitido campo em branco!!")
	private String nome;
	
	@Email
	@NotBlank(message = "Não permitido campo em branco!!")
	private String email;
	private LocalDateTime data;
	
	@NotBlank(message = "Não permitido campo em branco!!")
	@Length(min= 10, message = "Não permitido menos de 10 caracteries")
	private String mensagem;

}
