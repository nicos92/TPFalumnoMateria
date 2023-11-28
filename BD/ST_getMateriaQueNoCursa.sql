CREATE DEFINER=`root`@`localhost` PROCEDURE `getMateriasQueNoCursa`(IN _ID INT)
BEGIN
	SELECT  *
	FROM materias
	WHERE idMateria NOT IN ( SELECT materias_idMateria
						FROM alumno_materia_cursada
						WHERE  Alumnos_idAlumno = _ID) 
	ORDER BY idMateria;
END