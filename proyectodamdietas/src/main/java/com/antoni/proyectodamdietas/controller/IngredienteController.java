package com.antoni.proyectodamdietas.controller;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.service.*;

@RestController
@RequestMapping("/api/ingredientes")
@CrossOrigin(origins = "http://localhost:5173")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteService.getAllIngredientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable int id) {
        Ingrediente ingrediente = ingredienteService.getIngredienteById(id);
        return ResponseEntity.ok(ingrediente);
    }

    @PostMapping
    public ResponseEntity<Ingrediente> createIngrediente(@Valid @RequestBody Ingrediente ingrediente) {
        Ingrediente createdIngrediente = ingredienteService.createIngrediente(ingrediente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngrediente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> updateIngrediente(@PathVariable int id, @Valid @RequestBody Ingrediente ingredienteDetails) {
        Ingrediente updatedIngrediente = ingredienteService.updateIngrediente(id, ingredienteDetails);
        return ResponseEntity.ok(updatedIngrediente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable int id) {
        ingredienteService.deleteIngrediente(id);
        return ResponseEntity.noContent().build();
    }
}
