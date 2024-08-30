package com.demo_backend.service;

import com.demo_backend.model.Cuenta;

public interface ICuentaService extends ICRUD<Cuenta, Long> {
	public Cuenta listarPorNumCuenta(String numcuenta);
}
