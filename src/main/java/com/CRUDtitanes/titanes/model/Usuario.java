package com.CRUDtitanes.titanes.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    @Column
    private String nombre;
    @Id
    private String nombreUsuario;
    @Column
    private String password;

    @OneToMany(mappedBy="usuario")
    private List<MovimientoDinero> movimientoDineros;



    public Usuario(String nombre, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}