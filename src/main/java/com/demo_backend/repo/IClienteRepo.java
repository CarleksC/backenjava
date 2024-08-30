package com.demo_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo_backend.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Long> {
	

}
