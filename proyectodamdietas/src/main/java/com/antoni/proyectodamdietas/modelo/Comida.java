package com.antoni.proyectodamdietas.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "comida")
@View(name="Simple", members="nombre, diaSemana, momentoDia, descripcion, ingredientes")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 100)
    private String nombre;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
    private DiaSemana diaSemana;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "momento_dia")
    private MomentoDia momentoDia;

    @NotNull
    @Size(min = 10, max = 255)
    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "comida_ingrediente",
        joinColumns = @JoinColumn(name = "id_comida"),
        inverseJoinColumns = @JoinColumn(name = "id_ingrediente")
    )
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_dieta")
    @JsonBackReference
    private Dieta dieta;

    // Constructor
    public Comida() {}

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

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public MomentoDia getMomentoDia() {
        return momentoDia;
    }

    public void setMomentoDia(MomentoDia momentoDia) {
        this.momentoDia = momentoDia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
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
        Comida other = (Comida) obj;
        return id == other.id;
    }

    public enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    public enum MomentoDia {
        DESAYUNO, ALMUERZO, COMIDA, MERIENDA, CENA
    }
}
