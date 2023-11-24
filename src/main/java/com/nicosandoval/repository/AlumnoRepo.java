package com.nicosandoval.repository;

import com.nicosandoval.modelo.Alumno;
import com.nicosandoval.modelo.Materia;
import jakarta.persistence.*;

import java.util.List;

public class AlumnoRepo {

    /**
     *
     * @param nombre ingresa una clase alumno para insertar en la base de datos
     * @return para saber si ingreso correctamente
     */
    public String insertAlumno(String nombre) {
        Alumno alumno = new Alumno(nombre);

        try (EntityManagerFactory EMF = Persistence
                        .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager EM = EMF.createEntityManager();
            EM.getTransaction().begin();

             EM.persist(alumno);

            EM.getTransaction().commit();


            EMF.close();
            EM.close();
            return "Alumno insertado" ;
        } catch (Exception e) {
            System.out.println("Error catch insert Alumno: " + e.getMessage());
        }

        return "Error al insertar Alumno: " + alumno;
    }


    /**
     *
     * @param idAlumno para obtener el id del alumno para su busqueda
     * @return valor buscado o null
     */
    public Alumno findAlumno(int idAlumno) {

        Alumno alumno1 = null;
        try  (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")){
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            alumno1 = em.find(Alumno.class, idAlumno);
            em.getTransaction().commit();

            emf.close();
            em.close();
            return alumno1;
        } catch (Exception e) {
            System.out.println("Error catch Find Alumno: " + alumno1 + " - " + e.getMessage());
        }

        return null;
    }

    /**
     *
     * @param idAlumno para buscar al alumno a remover
     * @return para saber si se removio correctamente
     */
    public String removeAlumno(int idAlumno) {

        Alumno alumno1 = null;
        try (
                EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            alumno1 = em.find(Alumno.class, idAlumno);


            em.remove(alumno1);

            em.getTransaction().commit();

            emf.close();
            em.close();
            return " Alumno Remove: " + alumno1;
        } catch (Exception e) {
            System.out.println("Error catch remove Alumno: " + alumno1 + " - " + e.getMessage());
        }

        return null;
    }

    /**
     *
     * @param idAlumno es para aidentificar al alumno
     * @param newNombre String que se envia para modificar el nombre
     * @return  para saber si se modifico correctamente
     */
    public Alumno updateNameAlumno(int idAlumno, String newNombre) {
        Alumno alumno1 = null;
        try (EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            alumno1 = em.find(Alumno.class, idAlumno);
            alumno1.setNombreAlumno(newNombre);

            em.persist(alumno1);

            em.getTransaction().commit();


            emf.close();
            em.close();
            return alumno1;
        } catch (Exception e) {
            System.out.println("Error catch update Alumno: " + alumno1 + " " + e.getMessage());
        }

        return null;
    }


    /**
     *
     * @return lista de entity Alumnos si puede traer, sino NULL
     */
    @SuppressWarnings("unchecked")
    public List<Alumno> getAllAlumno() {

        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            Query query = em.createNativeQuery("SELECT * FROM alumnos ORDER BY idAlumno", Alumno.class);

            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Error catch get all Alumno: " + e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Materia> getMateriasAprobadas(int alumno){

        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            StoredProcedureQuery SPQ = em.createStoredProcedureQuery("getMateriasAprobadas", Materia.class)
                    .registerStoredProcedureParameter(1, Integer.class,
                            ParameterMode.IN)
                    .setParameter(1, alumno);

            return SPQ.getResultList();

        } catch (Exception e) {
            System.out.println("Error catch get Materias aprobadas: " + e.getMessage());
        }
        return null;

    }

    @SuppressWarnings("unchecked")
    public List<Materia> getMateriasDesaprobadas(int alumno) {
        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            StoredProcedureQuery SPQ = em.createStoredProcedureQuery("getMateriasDesaprobadas", Materia.class)
                    .registerStoredProcedureParameter(1, Integer.class,
                            ParameterMode.IN)
                    .setParameter(1, alumno);

            return SPQ.getResultList();

        } catch (Exception e) {
            System.out.println("Error catch get Materias Desaprobadas: " + e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Materia> getMateriasCursadas(int alumno) {
        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            StoredProcedureQuery SPQ = em.createStoredProcedureQuery("getMateriasCursadas", Materia.class)
                    .registerStoredProcedureParameter(1, Integer.class,
                            ParameterMode.IN)
                    .setParameter(1, alumno);

            return SPQ.getResultList();

        } catch (Exception e) {
            System.out.println("Error catch get Materias Cursadas: " + e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Materia> getMateriasNoCursadas(int alumno) {
        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            StoredProcedureQuery SPQ = em.createStoredProcedureQuery("getMateriasQueNoCursa", Materia.class)
                    .registerStoredProcedureParameter(1, Integer.class,
                            ParameterMode.IN)
                    .setParameter(1, alumno);

            return SPQ.getResultList();

        } catch (Exception e) {
            System.out.println("Error catch get Materias que No cursa: " + e.getMessage());
        }
        return null;
    }
}
