
-- obtener todos los alumnos
SELECT *
FROM alumnos
ORDER BY idAlumno;

-- obtener el id mas alto
SELECT * 
FROM ALumnos
WHERE idAlumno = (
SELECT max(idAlumno)
FROM Alumnos);

-- obtener todas las materias
SELECT *
FROM materias

ORDER BY idMateria;

-- obtener ID de alumno segun NOMBRE
SELECT *
FROM alumnos
WHERE nombre = "Nico";

-- obtener materia segun nombre de materia
SELECT *
FROM materias 
WHERE materia = "Fisica";

-- obtener almuno por ID
SELECT *
FROM alumnos
WHERE  idAlumno = 1;

-- obtener materia por ID
SELECT *
FROM materias
WHERE idMateria = 11;

-- obtener ID de materias correlativas
SELECT idMateria_correlativa as correlativa
FROM materias
WHERE idMateria_correlativa ;


-- obtener nombre de materias con correlativas y sus correlativas

SELECT t1.idMateria AS ID_materia, t1.materia AS Materia,   CASE
 WHEN t1.idMateria_correlativa = 15 THEN "" 
 ELSE t1.idMateria_correlativa 
 END AS ID_correlativa, t2.materia AS Correlativa
FROM materias t1, materias t2
WHERE t1.idMateria_correlativa  AND  t1.idMateria_Correlativa = t2.idMateria ;

-- obtener materias que no esta cursando alumno
SELECT  *
FROM materias
WHERE idMateria NOT IN ( SELECT materias_idMateria
					FROM alumno_materia_cursada
					WHERE  Alumnos_idAlumno = 1) AND idMateria <> 15;


-- OBTENER MATERIAS QUE NO ESTAN APROBADAS y no se estan cursando

SELECT  idMateria, materia
FROM materias
WHERE idMateria NOT  IN ( SELECT materias_idMateria
					FROM alumno_materia_cursada
					WHERE aprobada = 1 AND Alumnos_idAlumno = 1) AND idMateria <>15;


-- obtener IDs de las materias aprobadas segun nombre de alumno
SELECT Materias_idMateria
FROM alumno_materia_cursada
WHERE aprobada = 1 AND Alumnos_idAlumno = ( SELECT idAlumno
											FROM alumnos
                                            WHERE nombre = "Nico");
                                            
-- obtener materias aprobadas de cierto alumno por ID
SELECT idMateria, materia
FROM materias
WHERE idMateria IN ( SELECT materias_idMateria
					FROM alumngetMateriasAprobadaso_materia_cursada
                    WHERE aprobada = 1 AND Alumnos_idAlumno = 1);
                    
	
-- obtener materias por nombre de alumno                    
SELECT *
FROM materias
WHERE idMateria IN ( SELECT materias_idMateria
					FROM alumno_materia_cursada
                    WHERE aprobada = 1 AND Alumnos_idAlumno = ( SELECT idAlumno
																FROM alumnos
																WHERE nombre = "Nico"));
                    
                    

    

-- obtener materias aprobadas de cierto alumno por nombre          
SELECT materia
FROM materias
WHERE idMateria IN ( SELECT materias_idMateria
					FROM alumno_materia_cursada
                    WHERE aprobada = 1 AND Alumnos_idAlumno = ( SELECT idAlumno
																FROM alumnos
                                                                WHERE nombre = "Nico"));
                                                                
-- Obtener ID de alumnos que aprobaron o no cierta materia

SELECT Alumnos_idAlumno
FROM alumno_materia_cursada
WHERE aprobada = 1 AND Materias_idMateria = 1;                                                                
                                                                
-- obtener alumnos que aprobaron o no cierta materia

SELECT *
FROM alumnos
WHERE idAlumno IN (SELECT Alumnos_idAlumno
					FROM alumno_materia_cursada
					WHERE aprobada = 1 AND Materias_idMateria = 1);
      
      
-- insertar alumno
INSERT INTO `alumnos` (`Nombre`) VALUES ('Diana');

-- actulizar nombre de alumno
UPDATE `alumnos` SET `Nombre` = 'Angy' WHERE (`idAlumno` = '3');

-- insertar Materia
INSERT INTO `materiascorrelativas`.`materias` (`Materia`, `idMateria_Correlativa`) VALUES ('Informatica 3', '11');

-- actualizar nombre de materia
UPDATE `materiascorrelativas`.`materias` SET `Materia` = 'Fisica 1' WHERE (`idMateria` = '1');

-- insertar aprobacion segun ID de alumno, ID de materia y aprobacion
INSERT INTO `materiascorrelativas`.`alumno_materia_cursada` (`Alumnos_idAlumno`, `Materias_idMateria`, `aprobada`) VALUES ('2', '2', '0');

-- actualizar aprobacion de materia segun ID de alumno y ID de materia
UPDATE `materiascorrelativas`.`alumno_materia_cursada` SET `aprobada` = '1' WHERE (`Alumnos_idAlumno` = '2') and (`Materias_idMateria` = '1');





                    
                    
			