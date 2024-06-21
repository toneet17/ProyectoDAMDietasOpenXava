package com.antoni.proyectodamdietas.service;

import java.util.*;

import com.antoni.proyectodamdietas.modelo.*;

public interface IngredienteService {
    List<Ingrediente> getAllIngredientes();
    Ingrediente getIngredienteById(int id);
    Ingrediente createIngrediente(Ingrediente ingrediente);
    Ingrediente updateIngrediente(int id, Ingrediente ingrediente);
    void deleteIngrediente(int id);
}
