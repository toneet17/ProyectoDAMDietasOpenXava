package com.antoni.proyectodamdietas.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "dieta")
@View(name="Simple", members="nombre, descripcion, recomendaciones, comidas")
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 100)
    private String nombre;

    @Size(min = 3, max = 1000)
    @Lob
    private String descripcion;

    @Size(max = 1000)
    @Lob
    private String recomendaciones;

    @OneToMany(mappedBy = "dieta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Comida> comidas = new ArrayList<>();

    // Constructor
    public Dieta() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dieta other = (Dieta) obj;
        return id == other.id;
    }
}
