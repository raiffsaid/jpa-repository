package com.devsuperior.aulajparepository.controllers;

import com.devsuperior.aulajparepository.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users") // Mapeia o caminho do controlador
public class UserController {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> result = repository.findAll();

        return ResponseEntity.ok(result);
    }

}
