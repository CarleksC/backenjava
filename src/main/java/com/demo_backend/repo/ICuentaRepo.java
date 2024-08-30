package com.demo_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo_backend.model.Cuenta;

public interface ICuentaRepo extends JpaRepository<Cuenta, Long> {
	
	Cuenta findByNumerocuenta(String numCuenta);
}
