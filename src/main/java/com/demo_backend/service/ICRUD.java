package com.demo_backend.service;

import java.util.List;

public interface ICRUD<T,V> {
	T registrar(T obj);
	T modificar(T obj);
	T listarPorId(V id);
	List<T> listarTodo();
	void eliminar(V id);

}
