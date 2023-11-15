package com.jalaoui.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalaoui.demo.entities.Employe;
import com.jalaoui.demo.entities.Service;

public interface EmployeRepository extends JpaRepository<Employe, Long>{

	
	List<Employe> findByService(Service service);
}
