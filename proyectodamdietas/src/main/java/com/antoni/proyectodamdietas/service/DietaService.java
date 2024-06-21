package com.antoni.proyectodamdietas.service;

import java.util.*;

import com.antoni.proyectodamdietas.modelo.*;

public interface DietaService {
    List<Dieta> getAllDietas();
    Dieta getDietaById(int id);
    Comida getComidaById(int id);
    Dieta createDieta(Dieta dieta);
    Dieta updateDieta(int id, Dieta dieta);
    void deleteDieta(int id);
}
