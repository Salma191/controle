package com.jalaoui.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jalaoui.demo.dao.IDao;
import com.jalaoui.demo.entities.Service;
import com.jalaoui.demo.repositories.ServiceRepository;



@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service>{

	
	@Autowired
	private ServiceRepository repository; 
	
	@Override
	public Service create(Service o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Service o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Service> findAll() {
		return repository.findAll();
	}

	@Override
	public Service findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Service update(Service o) {
		return repository.save(o);
	}


}

