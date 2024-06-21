package com.antoni.proyectodamdietas.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.antoni.proyectodamdietas.exception.*;
import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.repository.*;
import com.antoni.proyectodamdietas.service.*;

@CrossOrigin(origins = "http://localhost:5173")
@Service
public class ComidaServiceImpl implements ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    @Override
    public List<Comida> getAllComidas() {
        return comidaRepository.findAll();
    }

    @Override
    public Comida getComidaById(int id) {
        return comidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comida not found with id: " + id));
    }

    @Override
    public Comida createComida(Comida comida) {
        return comidaRepository.save(comida);
    }

    @Override
    public Comida updateComida(int id, Comida comidaDetails) {
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comida not found with id: " + id));
        comida.setNombre(comidaDetails.getNombre());
        comida.setDiaSemana(comidaDetails.getDiaSemana());
        comida.setMomentoDia(comidaDetails.getMomentoDia());
        comida.setDescripcion(comidaDetails.getDescripcion());
        comida.setIngredientes(comidaDetails.getIngredientes());
        return comidaRepository.save(comida);
    }

    @Override
    public void deleteComida(int id) {
        Comida comida = comidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comida not found with id: " + id));
        comidaRepository.delete(comida);
    }
}
