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

import com.jalaoui.demo.entities.Service;
import com.jalaoui.demo.services.ServiceService;

@RestController
@RequestMapping("/services")
public class ServiceController {

	@Autowired
    private ServiceService ServiceService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Service ServiceD) {
        Service service = ServiceService.create(ServiceD);
        if (service == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Service service = ServiceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = ServiceService.delete(service);
            if (deleted) {
                return new ResponseEntity<>("Service deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Service associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Service Service) {
        if (ServiceService.findById(id) == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            Service.getId(id);
            return new ResponseEntity<>(ServiceService.update(Service), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Service>> findAll() {
        return new ResponseEntity<>(ServiceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Service service = ServiceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }
}
