package com.nicosandoval.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Table(name = "alumnos")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Alumno  implements Serializable{

    @Id
    @Column(name = "idAlumno")
    int idAlumno;

    @NonNull
    @Column(name = "Nombre")
    String nombreAlumno;


}