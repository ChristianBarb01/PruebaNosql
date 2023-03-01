package com.PruebaBarbecho.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "profesor")
@Data
public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long prof_id;
	private String nombre;
	private Long dept_id;
	private String direccion;
	private String telefono;

	// Relaciones
	
	private Curso curso;
}
