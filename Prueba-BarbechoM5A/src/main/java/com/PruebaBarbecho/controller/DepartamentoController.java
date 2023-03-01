package com.PruebaBarbecho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PruebaBarbecho.entity.Departamento;
import com.PruebaBarbecho.service.IDepartamentoService;

@RestController
@RequestMapping("/api/prueba")
public class DepartamentoController {

	@Autowired
	IDepartamentoService depService;



	@PostMapping("/registrar")
	public ResponseEntity<Departamento> registrarDepartamento(@RequestBody Departamento p) {
		return new ResponseEntity<>(depService.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable Long id, @RequestBody Departamento d) {
		Departamento depEncontrado = depService.findById(id);
		if (depEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				depEncontrado.setNombre(d.getNombre());
				depEncontrado.setDirector(d.getDirector());
				depEncontrado.setDescripcion(d.getDescripcion());
				return new ResponseEntity<>(depService.save(d), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Departamento> eliminarDepartamento(@PathVariable Long id) {
		depService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/listar")
	public ResponseEntity<List<Departamento>> listarDepartamento() {
		return new ResponseEntity<>(depService.findByAll(), HttpStatus.OK);
	}
}
