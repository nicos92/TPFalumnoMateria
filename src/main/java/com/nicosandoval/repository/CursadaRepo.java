package com.nicosandoval.repository;

import com.nicosandoval.modeloEntity.Cursada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class CursadaRepo {

    /**
     *
     * @param cursada ingresa una clase Cursada para insertar en la base de datos
     * @return para saber si ingreso correctamente
     */
    public String insertCursada(Cursada cursada) {

        try (EntityManagerFactory EMF = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager EM = EMF.createEntityManager();
            EM.getTransaction().begin();

            EM.persist(cursada);

            EM.getTransaction().commit();


            EMF.close();
            EM.close();
            return "Cursada insertada" ;
        } catch (Exception e) {
            System.out.println("catch insert Cursada: " + e.getMessage());
        }

        return "Error al insertar Cursada: " + cursada;
    }

    /**
     *
     * @return lista de entity Cursada si puede traer, sino NULL
     */
    @SuppressWarnings("unchecked")
    public List<Cursada> getAllCursada() {

        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            Query query = em.createNativeQuery("SELECT * FROM alumno_materia_cursada ORDER BY Alumnos_idAlumno"
                    , Cursada.class);

            return query.getResultList();

        } catch (Exception e) {
            System.out.println("catch get all Cursada: " + e.getMessage());
        }
        return null;
    }


    public Cursada findCursada(int idCursada) {

        Cursada cursada = null;
        try  (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")){
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            cursada = em.find(Cursada.class, idCursada);
            em.getTransaction().commit();

            emf.close();
            em.close();
            return cursada;
        } catch (Exception e) {
            System.out.println("catch Find Alumno: " + cursada + " - " + e.getMessage());
        }

        return null;
    }

    public String removeCursada(int idCursada) {
        Cursada Cursada = null;
        try (
                EntityManagerFactory emf = Persistence
                        .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            Cursada = em.find(Cursada.class, idCursada);


            em.remove(Cursada);

            em.getTransaction().commit();

            emf.close();
            em.close();
            return " Cursada Remove: " + Cursada;
        } catch (Exception e) {
            System.out.println("catch remove Alumno: " + Cursada + " - " + e.getMessage());
        }
        return null;
    }

    public Cursada updateAprobacion(int idCursada, int aprobacion) {
        Cursada cursada = null;
        try (EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            cursada = em.find(Cursada.class, idCursada);
            cursada.setAprobada(aprobacion);

            em.persist(cursada);

            em.getTransaction().commit();


            emf.close();
            em.close();
            return cursada;
        } catch (Exception e) {
            System.out.println("catch update Alumno: " + cursada + " " + e.getMessage());
        }

        return null;
    }
}
