package com.demo_backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_backend.model.Cuenta;
import com.demo_backend.repo.ICuentaRepo;
import com.demo_backend.service.ICuentaService;

@Service
public class CuentaServiceImpl implements ICuentaService{

	@Autowired
	private ICuentaRepo repo;
	
	@Override
	public Cuenta registrar(Cuenta obj) {
		return repo.save(obj);
	}

	@Override
	public Cuenta modificar(Cuenta obj) {
		return repo.save(obj);
	}

	@Override
	public Cuenta listarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Cuenta> listarTodo() {

		return repo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Cuenta listarPorNumCuenta(String numcuenta) {

		return repo.findByNumerocuenta(numcuenta);
	}
	
	

}
