package com.nicosandoval.modeloEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 * Implementacion de patron de diseño Java Bean
 */
@Entity
@Table(name = "alumnos")
public class Alumno  implements Serializable{

    @Id
    @Column(name = "idAlumno")
    private int idAlumno;

    @Column(name = "Nombre")
    private String nombreAlumno;

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "idAlumno=" + idAlumno +
                ", nombreAlumno='" + nombreAlumno + '\'' +
                '}';
    }
}