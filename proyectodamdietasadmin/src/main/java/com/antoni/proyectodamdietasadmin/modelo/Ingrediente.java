package com.antoni.proyectodamdietasadmin.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "ingrediente")
@View(name="Simple", members="nombre, descripcion, precioAprox, imagen, calorias, proteinas, carbohidratos, grasas")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 100)
    private String nombre;

    @Lob
    @Size(min = 3, max = 1000)
    private String descripcion;

    @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "precio_aprox")
    private double precioAprox;

    private String imagen;

    @Min(0)
    private int calorias;

    @Min(0)
    private double proteinas;

    @Min(0)
    private double carbohidratos;

    @Min(0)
    private double grasas;

    @ManyToMany(mappedBy = "ingredientes")
    @JsonBackReference
    private List<Comida> comidas = new ArrayList<>();

    // Constructor
    public Ingrediente() {}

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

    public double getPrecioAprox() {
        return precioAprox;
    }

    public void setPrecioAprox(double precioAprox) {
        this.precioAprox = precioAprox;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
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
        Ingrediente other = (Ingrediente) obj;
        return id == other.id;
    }
}
