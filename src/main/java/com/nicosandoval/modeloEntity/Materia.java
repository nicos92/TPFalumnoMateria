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
@Table(name = "materias")
public class Materia  implements Serializable {


    @Id
    @Column(name = "idMateria")
    private int idMateria;

    @Column(name = "Materia")
    private String nombreMateria;


    @Column(name = "idCorrelativa")
    private int idMateriaCorreletiva;

    public Materia() {
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getIdMateriaCorreletiva() {
        return idMateriaCorreletiva;
    }

    public void setIdMateriaCorreletiva(int idMateriaCorreletiva) {
        this.idMateriaCorreletiva = idMateriaCorreletiva;
    }
    @Override
    public String toString() {
        return "Materia{" +
                "idMateria=" + idMateria +
                ", nombreMateria='" + nombreMateria + '\'' +
                ", idMateriaCorreletiva=" + idMateriaCorreletiva +
                '}';
    }
}