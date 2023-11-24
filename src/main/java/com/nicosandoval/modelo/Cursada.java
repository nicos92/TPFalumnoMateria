package com.nicosandoval.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Table(name = "alumno_materia_cursada")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cursada implements Serializable {


    @Id
    @Column(name = "idCursada")
    int idCursada;

    @NonNull
    @Column(name = "Alumnos_idAlumno")
    int alumno;


    @NonNull
    @Column(name = "Materias_idMateria")
    int materia;

    @NonNull
    @Column(name = "aprobada")
    int aprobada;
}