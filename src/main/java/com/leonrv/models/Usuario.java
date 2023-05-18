package com.leonrv.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.*;


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
    private Date fechaNacimiento;
}
