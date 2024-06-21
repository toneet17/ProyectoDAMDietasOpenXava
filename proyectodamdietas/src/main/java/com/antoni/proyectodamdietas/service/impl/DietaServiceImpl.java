package com.antoni.proyectodamdietas.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.antoni.proyectodamdietas.exception.*;
import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.repository.*;
import com.antoni.proyectodamdietas.service.*;

@Service
public class DietaServiceImpl implements DietaService {

    @Autowired
    private DietaRepository dietaRepository;

    @Autowired
    private ComidaRepository comidaRepository;

    @Override
    public List<Dieta> getAllDietas() {
        return dietaRepository.findAll();
    }

    @Override
    public Dieta getDietaById(int id) {
        return dietaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dieta not found with id: " + id));
    }

    @Override
    public Comida getComidaById(int id) {
        return comidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comida not found with id: " + id));
    }

    @Override
    public Dieta createDieta(Dieta dieta) {
        return dietaRepository.save(dieta);
    }

    @Override
    public Dieta updateDieta(int id, Dieta dietaDetails) {
        Dieta dieta = dietaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dieta not found with id: " + id));
        dieta.setNombre(dietaDetails.getNombre());
        dieta.setDescripcion(dietaDetails.getDescripcion());
        dieta.setRecomendaciones(dietaDetails.getRecomendaciones());
        dieta.setComidas(dietaDetails.getComidas());
        return dietaRepository.save(dieta);
    }

    @Override
    public void deleteDieta(int id) {
        Dieta dieta = dietaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dieta not found with id: " + id));
        dietaRepository.delete(dieta);
    }
}
