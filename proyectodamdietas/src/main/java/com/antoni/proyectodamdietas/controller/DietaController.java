package com.antoni.proyectodamdietas.controller;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.service.*;

@RestController
@RequestMapping("/api/dietas")
@CrossOrigin(origins = "http://localhost:5173")
public class DietaController {

    @Autowired
    private DietaService dietaService;

    @GetMapping
    public ResponseEntity<List<Dieta>> getAllDietas() {
        List<Dieta> dietas = dietaService.getAllDietas();
        return ResponseEntity.ok(dietas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dieta> getDietaById(@PathVariable int id) {
        Dieta dieta = dietaService.getDietaById(id);
        return ResponseEntity.ok(dieta);
    }

    @PostMapping
    public ResponseEntity<Dieta> createDieta(@Valid @RequestBody Dieta dieta) {
        Dieta createdDieta = dietaService.createDieta(dieta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDieta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dieta> updateDieta(@PathVariable int id, @Valid @RequestBody Dieta dietaDetails) {
        Dieta updatedDieta = dietaService.updateDieta(id, dietaDetails);
        return ResponseEntity.ok(updatedDieta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDieta(@PathVariable int id) {
        dietaService.deleteDieta(id);
        return ResponseEntity.noContent().build();
    }
}
