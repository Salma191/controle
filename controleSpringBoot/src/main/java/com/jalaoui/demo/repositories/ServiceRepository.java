package com.jalaoui.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalaoui.demo.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{

}
