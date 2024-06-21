package com.antoni.proyectodamdietas.service;

import java.util.*;

import com.antoni.proyectodamdietas.modelo.*;

public interface ComidaService {
    List<Comida> getAllComidas();
    Comida getComidaById(int id);
    Comida createComida(Comida comida);
    Comida updateComida(int id, Comida comida);
    void deleteComida(int id);
}
