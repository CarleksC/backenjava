package com.demo_backend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo_backend.model.Movimientos;
import com.demo_backend.repo.IMovimientosRepo;
import com.demo_backend.service.IMovimientosService;

@Service
public class MovimientosServiceImpl implements IMovimientosService{

	@Autowired
	private IMovimientosRepo repo;
	
	@Override
	public Movimientos registrar(Movimientos obj) {
		return repo.save(obj);
	}

	@Override
	public Movimientos modificar(Movimientos obj) {
		return repo.save(obj);
	}

	@Override
	public Movimientos listarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Movimientos> listarTodo() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

}
