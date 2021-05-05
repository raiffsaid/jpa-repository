package com.devsuperior.aulajparepository.controllers;

import com.devsuperior.aulajparepository.entities.User;
import com.devsuperior.aulajparepository.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users") // Mapeia o caminho do controlador
public class UserController {
    @Autowired // Injeta uma instância do objeto
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> result = repository.findAll();

        return ResponseEntity.ok(result);
    }

    // Retorna os dados paginados
    @GetMapping(value = "/page")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        Page<User> result = repository.findAll(pageable);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search-salary")
    public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
        Page<User> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search-name")
    public ResponseEntity<Page<User>> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable) {
        Page<User> result = repository.findByNameContainingIgnoreCase(name, pageable);
        return ResponseEntity.ok(result);
    }
}
