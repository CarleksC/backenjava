package com.demo_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo_backend.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Long> {
	

}
