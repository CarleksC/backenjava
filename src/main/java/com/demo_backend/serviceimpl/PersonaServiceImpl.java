package com.demo_backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_backend.model.Persona;
import com.demo_backend.repo.IPersonaRepo;
import com.demo_backend.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;
	
	@Override
	public Persona registrar(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public Persona modificar(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public Persona listarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Persona> listarTodo() {

		return repo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

}
