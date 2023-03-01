package com.PruebaBarbecho.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.PruebaBarbecho.entity.Departamento;

public interface IDepartamentoRepo extends MongoRepository<Departamento, Long> {

}
