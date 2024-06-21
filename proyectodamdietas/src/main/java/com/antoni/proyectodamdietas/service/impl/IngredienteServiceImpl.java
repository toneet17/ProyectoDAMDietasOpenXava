package com.antoni.proyectodamdietas.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.antoni.proyectodamdietas.exception.*;
import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.repository.*;
import com.antoni.proyectodamdietas.service.*;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    @Override
    public Ingrediente getIngredienteById(int id) {
        return ingredienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingrediente not found with id: " + id));
    }

    @Override
    public Ingrediente createIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public Ingrediente updateIngrediente(int id, Ingrediente ingredienteDetails) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingrediente not found with id: " + id));
        ingrediente.setNombre(ingredienteDetails.getNombre());
        ingrediente.setDescripcion(ingredienteDetails.getDescripcion());
        ingrediente.setPrecioAprox(ingredienteDetails.getPrecioAprox());
        ingrediente.setImagen(ingredienteDetails.getImagen());
        ingrediente.setCalorias(ingredienteDetails.getCalorias());
        ingrediente.setProteinas(ingredienteDetails.getProteinas());
        ingrediente.setCarbohidratos(ingredienteDetails.getCarbohidratos());
        ingrediente.setGrasas(ingredienteDetails.getGrasas());
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public void deleteIngrediente(int id) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingrediente not found with id: " + id));
        ingredienteRepository.delete(ingrediente);
    }
}
