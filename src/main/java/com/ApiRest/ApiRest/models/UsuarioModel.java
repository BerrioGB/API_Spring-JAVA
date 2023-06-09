package com.ApiRest.ApiRest.models;

import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private Integer prioridad;

    public void setPrioridad(Integer prioridad){
        this.prioridad = prioridad;
    }
    public Integer getPrioridad(){
        return prioridad;
    }
    
    public Long getId(){
        return id;
    }
    public void setID(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
