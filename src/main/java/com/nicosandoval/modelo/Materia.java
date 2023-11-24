package com.nicosandoval.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Table(name = "materias")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Materia  implements Serializable {

    @Id
    @Column(name = "idMateria")
    int idMateria;

    @NonNull
    @Column(name = "Materia")
    String nombreMateria;

    @NonNull
    @Column(name = "idMateria_Correlativa")
    int idMateriaCorreletiva;
}