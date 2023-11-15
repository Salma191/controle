package com.jalaoui.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalaoui.demo.entities.Employe;
import com.jalaoui.demo.entities.Service;
import com.jalaoui.demo.services.EmployeService;

@RequestMapping("/employes")
@RestController
public class EmployeController {

	@Autowired
    private EmployeService employeService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Employe ServiceD) {
    	Employe employe = employeService.create(ServiceD);
        if (employe == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(employe, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Employe employe = employeService.findById(id);
        if (employe == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = employeService.delete(employe);
            if (deleted) {
                return new ResponseEntity<>("Employe deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Employe associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Employe Service) {
        if (employeService.findById(id) == null) {
            return new ResponseEntity<>("Employe not found", HttpStatus.NOT_FOUND);
        } else {
            Service.getId(id);
            return new ResponseEntity<>(employeService.update(Service), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Employe>> findAll() {
        return new ResponseEntity<>(employeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Employe employe = employeService.findById(id);
        if (employe == null) {
            return new ResponseEntity<>("Employe not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employe, HttpStatus.OK);
        }
    }
    
    @GetMapping("/service/{id}")
    public List<Employe> findByService(@RequestBody Service service){
    	return employeService.findByService(service);
    }
}
