package com.jalaoui.demo.dao;

import java.util.List;

public interface IDao<T>{
	
	T create(T o);
	boolean delete(T o);
	List<T> findAll();
	T findById(Long id);
	T update(T o);
}
