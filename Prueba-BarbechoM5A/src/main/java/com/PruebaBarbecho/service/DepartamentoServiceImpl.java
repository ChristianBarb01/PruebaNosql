package com.PruebaBarbecho.service;

import com.PruebaBarbecho.repository.IDepartamentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.PruebaBarbecho.entity.Departamento;

@Service
public class DepartamentoServiceImpl extends GenericServiceImpl<Departamento, Long> implements IDepartamentoService {

	@Autowired
	IDepartamentoRepo departamentoRepo;

	@Override
	public CrudRepository<Departamento, Long> getDao() {

		return departamentoRepo;
	}

}
