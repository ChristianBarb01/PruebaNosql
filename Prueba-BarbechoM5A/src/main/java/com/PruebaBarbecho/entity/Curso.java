package com.PruebaBarbecho.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "curso")
@Data
public class Curso implements Serializable {
	@Id
	private Long curso_id;
	private static final long serialVersionUID = 1L;

	private String nombre;
	private Long prof_id;
	private String nivel;

	private String descripcion;

}
