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
@Table(name = "alumno_materia_cursada")
public class Cursada implements Serializable {


    @Id
    @Column(name = "idCursada")
    int idCursada;

    @Column(name = "Alumnos_idAlumno")
    private int alumno;

    @Column(name = "Materias_idMateria")
    private int materia;


    @Column(name = "aprobada")
    private int aprobada;

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public int getAprobada() {
        return aprobada;
    }

    public void setAprobada(int aprobada) {
        this.aprobada = aprobada;
    }

    public Cursada() {
    }

    @Override
    public String toString() {
        return "Cursada{" +
                "idCursada=" + idCursada +
                ", alumno=" + alumno +
                ", materia=" + materia +
                ", aprobada=" + aprobada +
                '}';
    }
}