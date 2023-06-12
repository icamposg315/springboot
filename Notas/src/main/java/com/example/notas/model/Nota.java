package com.example.notas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@Table(name = "notas")
@EqualsAndHashCode
@Entity
public class Nota {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "periodo")
    private Date periodo;
    @Column(name = "tema")
    private String tema;
    @Column(name = "nota")
    private int nota;

}
