package com.antoni.proyectodamdietas.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import com.antoni.proyectodamdietas.modelo.*;

@Repository
public interface DietaRepository extends JpaRepository<Dieta, Integer> {
}
