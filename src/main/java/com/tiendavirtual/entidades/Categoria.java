package com.tiendavirtual.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tcategorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;
    
    @Column(name = "estante")
    private int estante;
    
    @Column(name = "hab", columnDefinition = "TINYINT(1)")
    private boolean hab;

    public Categoria() {
    }

    public Categoria(String nombre, int estante, boolean hab) {
        this.nombre = nombre;
        this.estante = estante;
        this.hab = hab;
    }

    public Categoria(int id, String nombre, int estante, boolean hab) {
        this.id = id;
        this.nombre = nombre;
        this.estante = estante;
        this.hab = hab;
    }

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

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }
   
}
