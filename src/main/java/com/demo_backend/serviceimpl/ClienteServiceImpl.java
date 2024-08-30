package com.demo_backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_backend.model.Cliente;
import com.demo_backend.repo.IClienteRepo;
import com.demo_backend.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	public Cliente registrar(Cliente obj) {
		return repo.save(obj);
	}

	@Override
	public Cliente modificar(Cliente obj) {
		return repo.save(obj);
	}

	@Override
	public Cliente listarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> listarTodo() {

		return repo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

}
