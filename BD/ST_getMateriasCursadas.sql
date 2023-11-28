CREATE DEFINER=`root`@`localhost`PROCEDURE `getMateriasCursadas` (IN _ID INT)
BEGIN
SELECT *
FROM materias
WHERE idMateria IN ( 
					SELECT Materias_idMateria
					FROM alumno_materia_cursada
					WHERE Alumnos_idAlumno = _ID
                    )
ORDER BY idMateria;

END
