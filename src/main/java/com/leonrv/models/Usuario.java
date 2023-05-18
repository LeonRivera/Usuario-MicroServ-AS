package com.leonrv.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{
    static final long serialVersionUID = 3L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correoElectronico;
    @Column
    // @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correoElectronico="
                + correoElectronico + ", fechaNacimiento=" + fechaNacimiento + "]";
    }

    
    
}
