package com.antoni.proyectodamdietas.controller;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.service.*;

@RestController
@RequestMapping("/api/comidas")
@CrossOrigin(origins = "http://localhost:5173")
public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping
    public List<Comida> getAllComidas() {
        return comidaService.getAllComidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> getComidaById(@PathVariable int id) {
        Comida comida = comidaService.getComidaById(id);
        return ResponseEntity.ok(comida);
    }

    @PostMapping
    public ResponseEntity<Comida> createComida(@Valid @RequestBody Comida comida) {
        Comida createdComida = comidaService.createComida(comida);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> updateComida(@PathVariable int id, @Valid @RequestBody Comida comidaDetails) {
        Comida updatedComida = comidaService.updateComida(id, comidaDetails);
        return ResponseEntity.ok(updatedComida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComida(@PathVariable int id) {
        comidaService.deleteComida(id);
        return ResponseEntity.noContent().build();
    }
}
