package com.demo_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo_backend.model.Movimientos;

public interface IMovimientosRepo extends JpaRepository<Movimientos, Long> {
	

}
